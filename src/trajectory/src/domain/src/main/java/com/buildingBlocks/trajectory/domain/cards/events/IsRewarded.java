package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class IsRewarded extends DomainEvent {

    private final String nameReward;
    private final String descriptionReward;
    private final String state;
    private final String type;
    private final String value;

    public String getNameReward() {
        return nameReward;
    }

    public String getDescriptionReward() {
        return descriptionReward;
    }

    public String getState() {
        return state;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }


    public IsRewarded( String nameReward, String descriptionReward, String state, String type, String value){
        super(NameEventsListEnum.IS_REWARDED.name());
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.state = state;
        this.type = type;
        this.value = value;
    }


}