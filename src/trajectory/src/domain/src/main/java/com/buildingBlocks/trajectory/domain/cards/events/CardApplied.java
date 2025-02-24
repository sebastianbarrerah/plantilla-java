package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardApplied extends DomainEvent {
    private final String type;
    private final String effect;

    public CardApplied( String type, String effect){
        super(NameEventsListEnum.CARD_APPLIED.name());
        this.type = type;
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }
}