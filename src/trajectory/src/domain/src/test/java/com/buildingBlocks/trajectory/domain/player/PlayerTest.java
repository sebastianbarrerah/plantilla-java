package com.buildingBlocks.trajectory.domain.player;

import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingBlocks.trajectory.domain.player.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.buildingBlocks.trajectory.domain.player.values.TypePropertyEnum.MANSION;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setMoney(new Diner(0));
    }

    @Test
    void acquirePropertySuccess() {
        Address address = new Address("123 Main St", "5", "New York");
        ValueProperty value = new ValueProperty(50000L);
        TypeProperty type = new TypeProperty(MANSION);

        player.acquireProperty(address, value, type);

        assertEquals(1, player.getProperties().size());
        Properties acquiredProperty = player.getProperties().get(0);
        assertEquals("123 Main St", acquiredProperty.getAddress().getValue());
        assertEquals(50000L, acquiredProperty.getValue().getAmount());
        assertEquals(MANSION, acquiredProperty.getType().getValue());

        assertEquals(1, player.getUncommittedEvents().size());
        assertInstanceOf(AcquiredProperty.class, player.getUncommittedEvents().get(0));
    }

    @Test
    void propertySoldSuccess() {
        Address address = new Address("456 Elm St", "25b", "Belen");
        ValueProperty value = new ValueProperty(60000L);
        TypeProperty type = new TypeProperty(MANSION);

        player.acquireProperty(address, value, type);
        assertEquals(1, player.getProperties().size());

        player.propertySold("1", address, new Diner(60000), type);

        assertTrue(player.getProperties().isEmpty());
        assertEquals(60000, player.getMoney().getAmount());
        assertEquals(2, player.getUncommittedEvents().size());
        assertInstanceOf(PropertySold.class, player.getUncommittedEvents().get(1));
    }

    @Test
    void makeMoneySuccess() {
        Diner amount = new Diner(2000);
        player.makeMoney(amount);

        assertEquals(2000, player.getMoney().getAmount());
        assertEquals(1, player.getUncommittedEvents().size());
        assertInstanceOf(MakeMoney.class, player.getUncommittedEvents().get(0));
    }

    @Test
    void loseMoneySuccess() {
        player.setMoney(new Diner(5000));
        Diner amount = new Diner(1000);

        player.loseMoney(amount);

        assertEquals(4000, player.getMoney().getAmount());
        assertEquals(1, player.getUncommittedEvents().size());
        assertInstanceOf(LoseMoney.class, player.getUncommittedEvents().get(0));
    }

    @Test
    void loseMoneyFailsWithInsufficientFunds() {
        player.setMoney(new Diner(500));
        Diner amount = new Diner(1000);

        assertThrows(IllegalArgumentException.class, () -> player.loseMoney(amount));
    }
}
