package com.buildingblocks.tajectory.infra.mainservice.controllers;

import com.buildingBlocks.trajectory.application.changeCareer.ChangeCareerRequest;
import com.buildingBlocks.trajectory.application.changeCareer.ChangeCareerResponse;
import com.buildingBlocks.trajectory.application.changeCareer.ChangeCareerUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/change-career")
public class ChangeCareerController {
    private final ChangeCareerUseCase useCase;

    public ChangeCareerController(ChangeCareerUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<ChangeCareerResponse> execute(@RequestBody ChangeCareerRequest request) {
        return useCase.execute(request);
    }
}
