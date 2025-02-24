package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.CardApplied;
import com.buildingBlocks.trajectory.domain.cards.events.CardDiscarded;
import com.buildingBlocks.trajectory.domain.cards.events.GroupImpact;
import com.buildingBlocks.trajectory.domain.cards.events.IsRewarded;
import com.buildingBlocks.trajectory.domain.cards.values.Card;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEffectEnum;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class CardsHandler extends DomainActionsContainer {

    public CardsHandler(Cards cardEvent){
        add(cardApplied(cardEvent));
        add(cardDiscarded(cardEvent));
        add(groupImpact(cardEvent));
        add(isRewarded(cardEvent));
    }

    public Consumer<? extends DomainEvent> cardApplied(Cards cardEvent) {
        return (CardApplied event) -> {
            String type = event.getType();
            String effect = event.getEffect();
            cardEvent.getListCards().add(Card.of(type, effect, 0));
        };
    }

    public Consumer<? extends DomainEvent> cardDiscarded(Cards cardEvent) {
        return (CardDiscarded event) -> {
            cardEvent.getListCards().add(Card.of("type", "effect", 0));
                cardEvent.getListCards().remove(cardEvent.getListCards().size() - 1);
        };
    }


    public Consumer<? extends DomainEvent> groupImpact(Cards cardEvent) {
        return (GroupImpact event) -> {
            Integer value = event.getValue();
            cardEvent.getType().equals(TypeEventEffectEnum.ALL_PLAYERS);
            cardEvent.getListCards().forEach(card -> card.getValueCard().equals(value));
        };
    }

    public Consumer<? extends DomainEvent> isRewarded(Cards cardEvent) {
        return (IsRewarded event) -> {
            Reward reward = new Reward(event.getNameReward(), event.getDescriptionReward(), event.getType(), event.getValue());
            cardEvent.getRewards().add(reward);
        };
    }





}



