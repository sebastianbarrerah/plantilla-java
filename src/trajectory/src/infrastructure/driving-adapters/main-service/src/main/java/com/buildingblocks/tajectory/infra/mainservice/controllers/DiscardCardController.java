package com.buildingblocks.tajectory.infra.mainservice.controllers;

import com.buildingBlocks.trajectory.application.discardCard.DiscardCardRequest;
import com.buildingBlocks.trajectory.application.discardCard.DiscardCardResponse;
import com.buildingBlocks.trajectory.application.discardCard.DiscardCardUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/discard-card")
public class DiscardCardController {

    private final DiscardCardUseCase useCase;

    public DiscardCardController(DiscardCardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<DiscardCardResponse> execute(@RequestBody DiscardCardRequest request) {
        return useCase.execute(request);
    }
}
