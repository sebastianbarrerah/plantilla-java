package com.buildingblocks.tajectory.infra.mainservice.controllers;

import com.buildingBlocks.trajectory.application.getCards.GetCardsResponse;
import com.buildingBlocks.trajectory.application.getCards.GetCardsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/get-cards")
public class GetCardsController {
    private final GetCardsUseCase useCase;

    public GetCardsController(GetCardsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public Flux<GetCardsResponse> execute() {
        return useCase.execute();
    }
}
