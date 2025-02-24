package com.buildingBlocks.trajectory.application.joinGame;

import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class JoinGameUseCase implements ICommandUseCase<JoinGameRequest, Mono<JoinGameResponse>> {

    private final IEventsRepository repository;

    public JoinGameUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<JoinGameResponse> execute(JoinGameRequest request) {

        Player player = new Player();
        player.playerCreated(request.getPlayerName());

        player.getUncommittedEvents().forEach(repository::save);
        player.markEventsAsCommitted();

        List<Players> jugadores = new ArrayList<>();
        jugadores.add(new Players(request.getPlayerName()));

        return Mono.just(
                new JoinGameResponse(
                        player.getIdentity().getValue(),
                        jugadores,
                        player.getBoardPosition().getNumberPosition()
                )
        );

    };
}
