package com.buildingBlocks.trajectory.application.buyProperty;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.events.CardApplied;
import com.buildingBlocks.trajectory.domain.player.events.AcquiredProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class BuyPropertyUseCaseTest {

    private final BuyPropertyUseCase useCase;
    private final IEventsRepositoryPort repository;

    public BuyPropertyUseCaseTest() {
        repository = Mockito.mock(IEventsRepositoryPort.class);
        useCase = new BuyPropertyUseCase(repository);
    }

    @Test
    void executeSuccess() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new AcquiredProperty("address", 100, "type"),
                new CardApplied("type", "effect")
        ));

        BuyPropertyRequest request = new BuyPropertyRequest("123", "address", 100, "type");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("address", response.getAddress());
                    assertEquals(100, response.getValue());
                    assertEquals("type", response.getType());
                    assertTrue(response.getType().equals("type"));
                    assertNotEquals(0, response.getValue());
                    assertNotEquals(0, response.getType());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

    @Test
    void executeNotSuccess() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new CardApplied("type", "effect"),
                new AcquiredProperty("address", 100, "type")
        ));

        BuyPropertyRequest request = new BuyPropertyRequest("123", "address", 100, "type");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotEquals(0, response.getValue());
                    assertFalse(response.getType().equals("types"));
                })

                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }
}