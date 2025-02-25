package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class ListCards extends DomainEvent {

    public ListCards(){
        super(NameEventsListEnum.LIST_CARDS.name());
    }

}
