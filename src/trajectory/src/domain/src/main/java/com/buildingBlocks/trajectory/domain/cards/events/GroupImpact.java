package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class GroupImpact extends DomainEvent {
    private final String type;
    private final String state;
    private final Integer value;

    public GroupImpact(String type, String state, Integer value){
        super(NameEventsListEnum.GROUP_IMPACT.name());
        this.type = type;
        this.state = state;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public Integer getValue() {
        return value;
    }
}