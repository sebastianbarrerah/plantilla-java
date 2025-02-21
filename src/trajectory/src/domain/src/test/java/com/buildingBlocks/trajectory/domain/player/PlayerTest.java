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
    }

    @Test
    void loseMoneySuccess() {
        player.setMoney(new Diner(5000));
        Diner amount = new Diner(1000);
        player.loseMoney(amount);
        assertEquals(4000, player.getMoney().getAmount());
        assertInstanceOf(LoseMoney.class, player.getUncommittedEvents().get(0));
    }

    @Test
    void acquirePropertySuccess() {
        Address address = new Address("123 Main St", "5", "New York");
        Diner value = new Diner(50000);
        TypeProperty type = new TypeProperty(TypePropertyEnum.MANSION);
        player.acquireProperty(address, value, type);
        assertNotEquals(0, player.getProperties().size());
    }

    @Test
    void propertySoldSuccess() {
        player.setMoney(new Diner(60000));
        Address address = new Address("456 Elm St", "25b", "Belen");
        Diner value = new Diner(60000);
        TypeProperty type = new TypeProperty(TypePropertyEnum.MANSION);
        player.acquireProperty(address, value, type);
        assertFalse(player.getProperties().isEmpty(), "El jugador no debe tener propiedades después de vender");
    }

    @Test
    void makeMoneySuccess() {
        Diner amount = new Diner(2000);
        player.makeMoney(amount);
        assertEquals(2000, player.getMoney().getAmount());

    }

    @Test
    void loseMoneyFailsWithInsufficientFunds() {
        player.setMoney(new Diner(500));
        Diner amount = new Diner(1000);
        assertThrows(IllegalArgumentException.class, () -> player.loseMoney(amount));
    }
};
