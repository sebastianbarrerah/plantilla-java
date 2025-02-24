package com.buildingBlocks.trajectory.domain.player;

import com.buildingBlocks.trajectory.domain.player.entities.Family;
import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingBlocks.trajectory.domain.player.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void testPlayerCreated() {
        String name = "John Doe";
        player.playerCreated(name);
        assertEquals(name, player.getName().getName());
    }

    @Test
    void testMovePositionWithinLimits() {
        player.playerMoved(150);
        assertEquals(150, player.getBoardPosition().getNumberPosition());
    }

    @Test
    void testMovePositionOutOfBounds() {
        player.playerMoved(400);
        assertNull(player.getBoardPosition());
    }

    @Test
    void testAcquireProperty() {
        player.acquireProperty("123 Street", 100000, "House");
        List<Properties> properties = player.getPropiedades();
        assertEquals(1, properties.size());
    }


    @Test
    void testPlayerMarriedAlreadyHasFamily() {
        player.setFamily(new Family(true, Children.of(0).getNumberOfChildren()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> player.playerMarried(true));
        assertEquals("El jugador ya tiene una familia", exception.getMessage());
    }

    @Test
    void testUpdateFamily() {
        player.setFamily(new Family(false, 0));
        player.updateFamily(2);
        assertEquals(2, player.getFamily().getChildren());
    }


    @Test
    void testUpdateFamilyInvalidChildren() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> player.updateFamily(5));
        assertThrows(IllegalArgumentException.class, () -> player.updateFamily(-1));
    }

    @Test
    void testUpdateProfession() {
        player.updateProfession("MAGISTER", "Bachelor", 50000);
        assertEquals("MAGISTER", player.getCareer().getName().getName());
        assertEquals("Bachelor", player.getCareer().getEducationalLevel().getLevel());
        assertEquals(50000, player.getCareer().getSalary().getAmount());
    }

    @Test
    void testPropertySold() {
        player.acquireProperty("123 Street", 100000, "House");
        player.propertySold("123 Street", 100000, "House");

    }

//    @Test
//    void testPropertySoldNotExists() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> player.propertySold("456 Avenue", 120000, "Apartment"));
//        assertEquals("La propiedad no existe", exception.getMessage());
//    }

    @Test
    void testPlayerFrom() {
        Player player = Player.from("player-123", List.of(new PlayerCreated("John Doe")));
        assertEquals("John Doe", player.getName().getName());
    }

};
