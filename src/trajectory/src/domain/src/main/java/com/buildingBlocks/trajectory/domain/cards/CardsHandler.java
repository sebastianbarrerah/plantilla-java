package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.CancelledEvent;
import com.buildingBlocks.trajectory.domain.cards.events.GroupImpact;
import com.buildingBlocks.trajectory.domain.cards.events.IsRewarded;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class CardsHandler extends DomainActionsContainer {

    public CardsHandler(Cards card){
        add(handleCancelledEvent(card));
        add(handleGroupImpact(card));
        add(handleIsRewarded(card));
    }

    private Consumer<DomainEvent> handleCancelledEvent(Cards card) {
        return event -> {
            CancelledEvent cancelledEvent = (CancelledEvent) event;
            System.out.println("Event Cancelled: " + cancelledEvent.getId());
        };
    }

    private Consumer<DomainEvent> handleGroupImpact(Cards card) {
        return event -> {
            GroupImpact groupImpact = (GroupImpact) event;
            System.out.println("Group Impact Applied: " + groupImpact.getValue());
        };
    }

    private Consumer<DomainEvent> handleIsRewarded(Cards card) {
        return event -> {
            IsRewarded isRewarded = (IsRewarded) event;
            System.out.println("Reward Assigned: " + isRewarded.getNameReward());
        };
    }
}



