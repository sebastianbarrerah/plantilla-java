package com.buildingblocks.tajectory.infra.mainservice.controllers;

import com.buildingBlocks.trajectory.application.getMarried.GetMarriedRequest;
import com.buildingBlocks.trajectory.application.getMarried.GetMarriedResponse;
import com.buildingBlocks.trajectory.application.getMarried.GetMarriedUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/get-married")
public class GetMarriedController {
    private final GetMarriedUseCase useCase;

    public GetMarriedController(GetMarriedUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<GetMarriedResponse> execute(@RequestBody GetMarriedRequest request) {
        return useCase.execute(request);
    }
}
