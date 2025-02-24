package com.buildingBlocks.trajectory.application.discardCard;

import com.buildingBlocks.trajectory.application.shared.repositorie.IEventsRepository;
import com.buildingBlocks.trajectory.domain.cards.events.CardDiscarded;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class DiscardCardUseCaseTest {
    private final DiscardCardUseCase useCase;
    private final IEventsRepository repository;

    public DiscardCardUseCaseTest() {
        repository = Mockito.mock(IEventsRepository.class);
        useCase = new DiscardCardUseCase(repository);
    }

    @Test
    void execute(){
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(new CardDiscarded("type", "state")));
        DiscardCardRequest request = new DiscardCardRequest("123", "type", "Activate");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("Carta descartada correctamente", response.getCardName());
                    assertTrue(true, response.getCardEffect());
                    assertNotNull(response.getCardName());
                })

                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

    @Test
    void executeNotNull(){
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(new CardDiscarded("type", "state")));
        DiscardCardRequest request = new DiscardCardRequest("123", "type", "Activate");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotEquals("type", response.getCardName());
                    assertFalse(false, response.getCardEffect());
                })

                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }
}