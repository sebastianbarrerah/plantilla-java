package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.CardApplied;
import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    private Cards cards;

    @BeforeEach
    void setUp() {
        cards = new Cards();
    }
    @Test
    void testCardApplied() {
        cards.cardApplied("Attack", "Lose 5 points");
        assertFalse(cards.getListCards().isEmpty());
        assertEquals("Attack", cards.getListCards().get(0).getNameCard());
        assertEquals("Lose 5 points", cards.getListCards().get(0).getEfectCard());
    }

    @Test
    void testCardDiscarded() {
        cards.cardApplied("Attack", "Lose 5 points");
        cards.cardDiscarded("Attack", "Used");
        assertTrue(cards.getListCards().isEmpty());
    }

    @Test
    void testGroupImpact() {
        cards.setType(TypeEvent.of(TypeEventEffectEnum.ALL_PLAYERS));
        cards.cardApplied("Defense", "Gain 3 points");
        cards.groupImpact("Defense", "Active", 3);
        assertEquals(0, cards.getListCards().get(0).getValueCard());
    }

    @Test
    void testIsRewarded() {
        cards.isRewarded("Gold Medal", "Win 10 points", "Achievement", 10);
        assertFalse(cards.getRewards().isEmpty());
        Reward reward = cards.getRewards().get(0);
        assertEquals("Gold Medal", reward.getNameReward());
        assertEquals(10, reward.getValueReward());
    }

//    @Test
//    void shouldCreateCardsWithGivenId() {
//        CardId cardId = CardId.of("test-id");
//
//        Cards cards = new Cards(cardId);
//
//        assertNotNull(cards);
//        assertEquals("test-id", cards.identity().value());
//    }

    @Test
    void shouldReconstructCardsFromEvents() {
        String cardId = "test-id";
        List<DomainEvent> events = List.of(
                new CardApplied("Attack", "Lose 10 points")
        );

        Cards reconstructedCards = Cards.from(cardId, events);

        assertNotNull(reconstructedCards);
        assertEquals(1, reconstructedCards.getListCards().size());
        assertEquals("Attack", reconstructedCards.getListCards().get(0).getNameCard());
        assertEquals("Lose 10 points", reconstructedCards.getListCards().get(0).getEfectCard());
    }
}
