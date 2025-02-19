package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {
    private Cards card;

    @BeforeEach
    void setUp() {
        card = new Cards();
    }

    @Test
    void cardInitialization() {
        assertNotNull(card.getId());
        assertEquals(TypeEvent.DECISION, card.getType());
        assertEquals(StateEvent.ACTIVE, card.getState());
        assertEquals(4, card.getUncommittedEvents().size());
    }

    @Test
    void validateStateOfCardThrowsExceptionWhenCompleted() {
        card.setState(StateEvent.COMPLETED);
        assertThrows(IllegalArgumentException.class, () -> card.validateStateOfCard(card.getId().getId()));
    }

    @Test
    void validateStateOfCardPassesWhenNotCompleted() {
        card.setState(StateEvent.ACTIVE);
        assertDoesNotThrow(() -> card.validateStateOfCard(card.getId().getId()));
    }
}
