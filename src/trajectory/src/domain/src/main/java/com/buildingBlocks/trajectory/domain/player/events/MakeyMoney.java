package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Diner;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class MakeyMoney extends DomainEvent {

    private final Diner amount;
    private Diner salary = Diner.of(0);

    public MakeyMoney(Diner amount){
        super(EventsNameEnum.MAKEY_MONEY.name());
        this.amount = amount;
        this.salary = Diner.of(0);
    }

    public Diner getAmount() {
        return amount;
    }

    public Diner getSalary() {
        return salary;
    }

}