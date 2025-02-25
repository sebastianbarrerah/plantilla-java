package com.buildingBlocks.trajectory.application.assignCardToPlayer;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.events.CardApplied;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class AssignCardToPlayerUseCaseTest {


    private final AssignCardToPlayerUseCase useCase;
    private final IEventsRepositoryPort repository;

    public AssignCardToPlayerUseCaseTest() {
        repository = Mockito.mock(IEventsRepositoryPort.class);
        useCase = new AssignCardToPlayerUseCase(repository);
    }

    @Test
    void executeSuccess() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just((
                new CardApplied("type", "effect")
                )));

        AssignCardToPlayerRequest request = new AssignCardToPlayerRequest("123", "type", "effect");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("type", response.getTypeCard());
                    assertEquals("effect", response.getEffectCard());
                    assertTrue(response.getEffectCard().equals("effect"));
                    assertNotEquals(0, response.getTypeCard());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

    @Test
    void executeNotSuccess() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just((
                new CardApplied("type", "effect")
        )));

        AssignCardToPlayerRequest request = new AssignCardToPlayerRequest("123", "type", "effect");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("type", response.getTypeCard());
                    assertFalse(response.getEffectCard().equals("effectCard"));
                })

                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }


}