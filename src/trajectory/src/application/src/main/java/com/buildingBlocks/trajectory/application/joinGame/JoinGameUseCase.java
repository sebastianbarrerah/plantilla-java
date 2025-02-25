package com.buildingBlocks.trajectory.application.joinGame;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class JoinGameUseCase implements ICommandUseCase<JoinGameRequest, Mono<JoinGameResponse>> {

    private final IEventsRepositoryPort repository;

    public JoinGameUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<JoinGameResponse> execute(JoinGameRequest request) {


        Player player = new Player();
        player.playerCreated(request.getPlayerName());

        player.getUncommittedEvents().forEach(repository::save);
        player.markEventsAsCommitted();

        return Mono.just(new JoinGameResponse(player.getName().getName(), "El jugador ha sido creado con exito"));
    }


}
