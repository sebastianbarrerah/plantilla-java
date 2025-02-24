package com.buildingBlocks.trajectory.application.assignCardToPlayer;

import com.buildingBlocks.trajectory.application.joinGame.JoinGameResponse;
import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class AssignCardToPlayerUseCase implements ICommandUseCase<AssignCardToPlayerRequest, Mono<AssignCardToPlayerResponse>> {

    private final IEventsRepository repository;

    public AssignCardToPlayerUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AssignCardToPlayerResponse> execute(AssignCardToPlayerRequest request) {

        return repository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Player player = Player.from(request.getAggregateId(), events);
                    Cards cards = Cards.from(request.getAggregateId(), events);

                    cards.cardApplied(request.getType(), request.getEffect());

                    player.getUncommittedEvents().forEach(repository::save);
                    player.markEventsAsCommitted();
                    return new AssignCardToPlayerResponse(cards.getListCards().get(cards.getListCards().size() - 1).getNameCard(), cards.getListCards().get(cards.getListCards().size() - 1).getEfectCard());
                });


    }
}
