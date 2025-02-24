package com.buildingBlocks.trajectory.application.discardCard;

import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DiscardCardUseCase implements ICommandUseCase<DiscardCardRequest, Mono<DiscardCardResponse>> {

    private final IEventsRepository repository;

    public DiscardCardUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<DiscardCardResponse> execute(DiscardCardRequest request) {
        return repository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {

                    Player player = Player.from(request.getAggregateId(), events);
                    Cards cards = Cards.from(request.getAggregateId(), events);

                    cards.cardDiscarded(request.getTypeCard(), request.getStateCard());


                    player.getUncommittedEvents().forEach(repository::save);
                    player.markEventsAsCommitted();

                    return new DiscardCardResponse(
                            player.getIdentity().getValue(),
                            "Carta descartada correctamente",
                            "Carta descartada correctamente"
                    );
                });
    }
}
