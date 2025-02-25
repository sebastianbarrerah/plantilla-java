package com.buildingblocks.tajectory.infra.mainservice.controllers;


import com.buildingBlocks.trajectory.application.buyProperty.BuyPropertyRequest;
import com.buildingBlocks.trajectory.application.buyProperty.BuyPropertyResponse;
import com.buildingBlocks.trajectory.application.buyProperty.BuyPropertyUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/buy-property")
public class BuyPropertyController {
    private final BuyPropertyUseCase useCase;

    public BuyPropertyController(BuyPropertyUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<BuyPropertyResponse> execute(@RequestBody BuyPropertyRequest request) {
        return useCase.execute(request);
    }
}
