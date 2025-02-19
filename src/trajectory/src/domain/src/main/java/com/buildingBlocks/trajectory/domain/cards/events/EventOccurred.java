package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class EventOccurred extends DomainEvent {
    private final String id;
    private final TypeEvent type;

    public EventOccurred(String id, TypeEvent type){
        super(NameEventsListEnum.EVENT_OCCURRED.name());
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public TypeEvent getType() {
        return type;
    }
}