package com.buildingBlocks.trajectory.application.assignCardToPlayer;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class AssignCardToPlayerUseCase implements ICommandUseCase<AssignCardToPlayerRequest, Mono<AssignCardToPlayerResponse>> {

    private final IEventsRepositoryPort repository;

    public AssignCardToPlayerUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AssignCardToPlayerResponse> execute(AssignCardToPlayerRequest request) {

        Cards cards = new Cards();

        cards.cardApplied(request.getType(), request.getEffect());
        cards.getUncommittedEvents().forEach(repository::save);
        cards.markEventsAsCommitted();
        return Mono.just(new AssignCardToPlayerResponse(cards.getListCards().get(cards.getListCards().size() - 1).getNameCard(), cards.getListCards().get(cards.getListCards().size() - 1).getEfectCard(), "Carta Asignada con exito"));

    };
}
