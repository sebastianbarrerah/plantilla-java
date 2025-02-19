package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Diner;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class LoseMoney extends DomainEvent {

    private final Diner amount;

    public LoseMoney(Diner amount){
        super(EventsNameEnum.LOSE_MONEY.name());
        this.amount = amount;
    }

    public Diner getAmount() {
        return amount;
    }

}