package com.buildingBlocks.trajectory.application.getMarried;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.events.IsRewarded;
import com.buildingBlocks.trajectory.domain.player.events.PlayerMarried;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class GetMarriedUseCaseTest {

    private final GetMarriedUseCase useCase;
    private final IEventsRepositoryPort repository;

    public GetMarriedUseCaseTest() {
        repository = Mockito.mock(IEventsRepositoryPort.class);
        useCase = new GetMarriedUseCase(repository);
    }

    @Test
    void execute(){
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(
                Flux.just(
                        new PlayerMarried(true),
                        new IsRewarded("Recompensa por casarse", "description", "Juan", 100)
                )
        );
        GetMarriedRequest request = new GetMarriedRequest("123", true);

        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("Juan", response.getPlayerName());
                    assertEquals(100, response.getMoney());
                    assertEquals(0, response.getPosition());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

    @Test
    void executeNotNull(){
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new PlayerMarried(true),
                new IsRewarded("Recompensa por casarse", "description", "Juan", 100)
        ));

        GetMarriedRequest request = new GetMarriedRequest("123", true);
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotEquals("david", response.getPlayerName());
                    assertTrue(true, response.getPlayerName());
                    assertEquals(0, response.getPosition());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }
}