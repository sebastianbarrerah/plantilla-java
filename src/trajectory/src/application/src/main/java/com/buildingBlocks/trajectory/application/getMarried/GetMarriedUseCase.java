package com.buildingBlocks.trajectory.application.getMarried;

import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEffectEnum;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class GetMarriedUseCase implements ICommandUseCase<GetMarriedRequest, Mono<GetMarriedResponse>> {

    private final IEventsRepository repository;

    public GetMarriedUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<GetMarriedResponse> execute(GetMarriedRequest request) {
        return repository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Player player = Player.from(request.getAggregateId(), events);
                    Cards cards = Cards.from(request.getAggregateId(), events);

                    player.playerMarried(request.getIsMarried());
                    cards.isRewarded("Recompensa por casarse", "Recompensa por casarse", TypeEventEffectEnum.PLAYER.name(), 100);

                    player.getUncommittedEvents().forEach(repository::save);
                    player.markEventsAsCommitted();

                    return new GetMarriedResponse(
                            "Juan",
                            100,
                            0
                    );
                });
    }
}
