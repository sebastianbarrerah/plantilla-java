package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class IsRewarded extends DomainEvent {

    private final String id;
    private final String nameReward;
    private final String descriptionReward;
    private final StateEvent state;
    private final TypeEvent type;
    private final String value;

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

    public String getValue() {
        return value;
    }

    public IsRewarded(String id, String nameReward, String descriptionReward, StateEvent state, TypeEvent type, String value){
        super(NameEventsListEnum.IS_REWARDED.name());
        this.id = id;
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.state = state;
        this.type = type;
        this.value = value;
    }

    public String getId() {
        return id;
    }

}