package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CancelledEvent extends DomainEvent {

    private final String id;
    private final TypeEvent type;
    private final StateEvent state;

    public CancelledEvent(String id, TypeEvent type, StateEvent state){
        super(NameEventsListEnum.CANCELLED_EVENT.name());
        this.id = id;
        this.type = type;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public TypeEvent getType() {
        return type;
    }

    public StateEvent getState() {
        return state;
    }
}