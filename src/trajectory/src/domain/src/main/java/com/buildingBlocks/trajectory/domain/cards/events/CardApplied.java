package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardApplied extends DomainEvent {
    private  String type;
    private  String effect;

    public CardApplied(){
        super(NameEventsListEnum.CARD_APPLIED.name());
    }

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

    public void setType(String type) {
        this.type = type;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}