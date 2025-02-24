package com.buildingBlocks.trajectory.application.buyProperty;

import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class BuyPropertyUseCase implements ICommandUseCase<BuyPropertyRequest, Mono<BuyPropertyResponse>> {

    private final IEventsRepository repository;

    public BuyPropertyUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BuyPropertyResponse> execute(BuyPropertyRequest request) {
        return repository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Player player = Player.from(request.getAggregateId(), events);
                    Cards cards = Cards.from(request.getAggregateId(), events);

                    player.acquireProperty(request.getAddress(), request.getValue(), request.getType());
                    cards.cardApplied(request.getType(), request.getValue().toString());

                    player.getUncommittedEvents().forEach(repository::save);
                    player.markEventsAsCommitted();
                    return new BuyPropertyResponse(
                            player.getPropiedades().get(player.getPropiedades().size() - 1).getAddress().getStreet(),
                            player.getPropiedades().get(player.getPropiedades().size() - 1).getValue().getAmount(),
                            player.getPropiedades().get(player.getPropiedades().size() - 1).getType().getTypeProperty()
                    );
                });
    }
}
