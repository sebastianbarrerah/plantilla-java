package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardDiscarded extends DomainEvent {

    private String type;
    private String state;

    public CardDiscarded(){
        super(NameEventsListEnum.CARD_DISCARDED.name());
    }

    public CardDiscarded( String type, String state){
        super(NameEventsListEnum.CARD_DISCARDED.name());
        this.type = type;
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(String state) {
        this.state = state;
    }
}