package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.QuantityReward;
import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateReward extends DomainEvent {
    private final String id;
    private final String nameReward;
    private final String descriptionReward;
    private final StateEvent state;
    private final TypeEvent type;
    private final QuantityReward quantityReward;

    public UpdateReward(String id, String nameReward, String descriptionReward, StateEvent state, TypeEvent type, QuantityReward quantityReward){
        super(NameEventsListEnum.UPDATE_REWARD.name());
        this.id = id;
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.state = state;
        this.type = type;
        this.quantityReward = quantityReward;
    }

    public String getId() {
        return id;
    }

    public String getNameReward() {
        return nameReward;
    }

    public String getDescriptionReward() {
        return descriptionReward;
    }

    public StateEvent getState() {
        return state;
    }

    public TypeEvent getType() {
        return type;
    }

    public QuantityReward getQuantityReward() {
        return quantityReward;
    }
}