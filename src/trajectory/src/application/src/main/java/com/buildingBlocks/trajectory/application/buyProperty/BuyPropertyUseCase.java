package com.buildingBlocks.trajectory.application.buyProperty;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class BuyPropertyUseCase implements ICommandUseCase<BuyPropertyRequest, Mono<BuyPropertyResponse>> {

    private final IEventsRepositoryPort repository;

    public BuyPropertyUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BuyPropertyResponse> execute(BuyPropertyRequest request) {
        Player player = new Player();
        Cards cards = new Cards();
        player.acquireProperty(request.getAddress(), request.getValue(), request.getType());
        cards.cardApplied(request.getType(), request.getValue().toString());
        player.getUncommittedEvents().forEach(repository::save);
        player.markEventsAsCommitted();
        cards.getUncommittedEvents().forEach(repository::save);
        cards.markEventsAsCommitted();
        return Mono.just(new BuyPropertyResponse(
                player.getPropiedades().get(player.getPropiedades().size() - 1).getAddress().getStreet(),
                player.getPropiedades().get(player.getPropiedades().size() - 1).getValue().getAmount(),
                player.getPropiedades().get(player.getPropiedades().size() - 1).getType().getTypeProperty(),
                "Propiedad Comprada con exito, se ha añadido la propiedad a la lista de propiedades"
        ));
    }
}
