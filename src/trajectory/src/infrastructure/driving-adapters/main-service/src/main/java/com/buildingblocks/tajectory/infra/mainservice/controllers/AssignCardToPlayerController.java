package com.buildingblocks.tajectory.infra.mainservice.controllers;


import com.buildingBlocks.trajectory.application.assignCardToPlayer.AssignCardToPlayerRequest;
import com.buildingBlocks.trajectory.application.assignCardToPlayer.AssignCardToPlayerResponse;
import com.buildingBlocks.trajectory.application.assignCardToPlayer.AssignCardToPlayerUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/assign-Card-Player")
public class AssignCardToPlayerController {
    private final AssignCardToPlayerUseCase useCase;

    public AssignCardToPlayerController(AssignCardToPlayerUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<AssignCardToPlayerResponse> execute(@RequestBody AssignCardToPlayerRequest request) {
        return useCase.execute(request);
    }
}
