package com.buildingBlocks.trajectory.application.joinGame;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class JoinGameUseCaseTest {

    private final JoinGameUseCase useCase;
    private final IEventsRepositoryPort repository;

    public JoinGameUseCaseTest() {
        repository = Mockito.mock(IEventsRepositoryPort.class);
        useCase = new JoinGameUseCase(repository);
    }

    @Test
    void executeSuccess() {
        JoinGameRequest request = new JoinGameRequest("jugador1");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals(0, response.getBoardPosition());
                    assertEquals(0, (long) response.getCardsMazo().size());
                    assertTrue(true, response.getGameId());
                    assertEquals(1, response.getPlayers().size());
                })
                .verifyComplete();
    }

    @Test
    void executeNotSuccess() {
        JoinGameRequest request = new JoinGameRequest("jugador1");
        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotEquals(4, response.getBoardPosition());
                    assertFalse(false, response.getGameId());
                    assertNotEquals(0, response.getPlayers().size());
                })
                .verifyComplete();
    }


}