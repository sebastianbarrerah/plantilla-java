package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class GroupImpact extends DomainEvent {
    private final TypeEvent type;
    private final StateEvent state;
    private final String value;

    public GroupImpact(TypeEvent type, StateEvent state, String value){
        super(NameEventsListEnum.GROUP_IMPACT.name());
        this.type = type;
        this.state = state;
        this.value = value;
    }

    public TypeEvent getType() {
        return type;
    }

    public StateEvent getState() {
        return state;
    }

    public String getValue() {
        return value;
    }
}