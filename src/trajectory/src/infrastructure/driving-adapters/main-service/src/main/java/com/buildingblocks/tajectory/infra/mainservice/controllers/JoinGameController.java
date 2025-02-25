package com.buildingblocks.tajectory.infra.mainservice.controllers;

import com.buildingBlocks.trajectory.application.joinGame.JoinGameRequest;
import com.buildingBlocks.trajectory.application.joinGame.JoinGameResponse;
import com.buildingBlocks.trajectory.application.joinGame.JoinGameUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/join-game")
public class JoinGameController {

    private final JoinGameUseCase useCase;

    public JoinGameController(JoinGameUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<JoinGameResponse> execute(@RequestBody JoinGameRequest request) {
        return useCase.execute(request);
    }

}
