package com.buildingBlocks.trajectory.application.getMarried;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEffectEnum;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class GetMarriedUseCase implements ICommandUseCase<GetMarriedRequest, Mono<GetMarriedResponse>> {

    private final IEventsRepositoryPort repository;

    public GetMarriedUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<GetMarriedResponse> execute(GetMarriedRequest request) {
              Player player = new Player();
              Cards cards = new Cards();

              player.playerMarried(request.getIsMarried());
              cards.isRewarded("Recompensa por cambiar de carrera", "Recompensa por cambiar de carrera", TypeEventEffectEnum.PLAYER.name(), 100);

        String message = request.getIsMarried()
                ? "¡Felicidades! Ahora estás casado."
                : "Has decidido no casarte en este turno.";

              player.getUncommittedEvents().forEach(repository::save);
              player.markEventsAsCommitted();

              cards.getUncommittedEvents().forEach(repository::save);
              cards.markEventsAsCommitted();

              return Mono.just(new GetMarriedResponse(
                      "jugador 1",
                      100,
                      0,
                      "¡Felicidades! Ahora estás casado."
              ));
    }
}
