package com.buildingBlocks.trajectory.application.discardCard;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.cards.values.Card;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DiscardCardUseCase implements ICommandUseCase<DiscardCardRequest, Mono<DiscardCardResponse>> {

    private final IEventsRepositoryPort repository;

    public DiscardCardUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<DiscardCardResponse> execute(DiscardCardRequest request) {
        Cards cards = new Cards();

        String type = "Type Card";
        String effect = "effect card";
        cards.getListCards().add(Card.of(type, effect, 0));

        cards.cardDiscarded(request.getTypeCard(), request.getStateCard());
        cards.getUncommittedEvents().forEach(repository::save);
        cards.markEventsAsCommitted();

        if (cards.getListCards().isEmpty()) {
            return Mono.error(new IllegalStateException("No hay cartas disponibles para descartar."));
        }

        return Mono.just(
                new DiscardCardResponse(
                        cards.getListCards().get(cards.getListCards().size() - 1).getNameCard(),
                        cards.getListCards().get(cards.getListCards().size() - 1).getEfectCard(),
            "La ultima carta ha sido descartada con exito"
                )
        );
    }

}
