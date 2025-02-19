package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PostponedEvent extends DomainEvent {

    private final String id;
    private final String state;
    private final TypeEvent type;

    public PostponedEvent(String id, String state, TypeEvent type){
        super(NameEventsListEnum.POSTPONED_EVENT.name());
        this.id = id;
        this.state = state;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public TypeEvent getType() {
        return type;
    }

}