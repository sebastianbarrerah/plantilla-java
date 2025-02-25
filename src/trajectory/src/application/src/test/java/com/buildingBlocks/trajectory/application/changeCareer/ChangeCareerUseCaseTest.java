package com.buildingBlocks.trajectory.application.changeCareer;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.events.CardApplied;
import com.buildingBlocks.trajectory.domain.cards.events.IsRewarded;
import com.buildingBlocks.trajectory.domain.player.events.UpdateProfession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class ChangeCareerUseCaseTest {
    private final ChangeCareerUseCase useCase;
    private final IEventsRepositoryPort repository;

    public ChangeCareerUseCaseTest() {
        repository = Mockito.mock(IEventsRepositoryPort.class);
        useCase = new ChangeCareerUseCase(repository);
    }

    @Test
    void executeSuccess() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new UpdateProfession("Medico", "Profesional", 10000),
                new IsRewarded("Recomepensa por cambiar de profesion", "description", "Player", 1000),
                new CardApplied("type", "effect")
        ));

        ChangeCareerRequest request = new ChangeCareerRequest("ar123","Medico", "Profesional", 1000, "type", "effect");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                   assertEquals(1000, response.getSalary());
                   assertEquals("Profesional", response.getEducationalLevel());
                   assertEquals("Medico", response.getNameProfession());
                   assertTrue(response.getNameProfession().equals("Medico"));
                   assertNotEquals(0, response.getSalary());
                   assertNotEquals(0, response.getNameProfession());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

    @Test
    void executeNotSuccess() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new CardApplied("type", "effect"),
                new UpdateProfession("Medico", "Profesional", 10000)
        ));

        ChangeCareerRequest request = new ChangeCareerRequest("ar123","Medico", "Profesional", 1000, "type", "effect");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotEquals(566, response.getSalary());
                    assertFalse(response.getNameProfession().equals("Medicos"));
                })

                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

}