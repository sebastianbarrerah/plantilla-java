package com.buildingBlocks.trajectory.application.changeCareer;

import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEffectEnum;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ChangeCareerUseCase implements ICommandUseCase<ChangeCareerRequest, Mono<ChangeCareerResponse>> {

    private final IEventsRepository repository;

    public ChangeCareerUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<ChangeCareerResponse> execute(ChangeCareerRequest request) {

        return repository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Player player = Player.from(request.getAggregateId(), events);
                    Cards cards = Cards.from(request.getAggregateId(), events);

                    player.updateProfession(request.getNameProfession(), request.getEducationalLevel(), request.getSalary());
                    cards.cardApplied(request.getCardType(), request.getCardEffect());
                    cards.isRewarded("Recompensa por cambiar de carrera", "Recompensa por cambiar de carrera", TypeEventEffectEnum.PLAYER.name(), 100);

                    player.getUncommittedEvents().forEach(repository::save);
                    player.markEventsAsCommitted();

                    return new ChangeCareerResponse(
                            player.getCareer().getName().getName(),
                            player.getCareer().getEducationalLevel().getLevel(),
                            player.getCareer().getSalary().getAmount()
                    );
                });
    }
}
