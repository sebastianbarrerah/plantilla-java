package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.StateEventEnum;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEnum;
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
    void testAlwaysTrue() {
        assertTrue(true, "Al iniciarlizar es verdadero");
    }

    @Test
    void testStringEquals() {
        String expected = "Hola";
        String actual = "Hola";
        assertEquals(expected, actual, "Los strings deben ser iguales");
    }


    @Test
    void testAssignReward() {
        Cards card = new Cards();
        card.assignReward("Bonus", "Extra Points", "100", "completed", "card");
        assertTrue(card.getRewards().isEmpty());
    }
}
