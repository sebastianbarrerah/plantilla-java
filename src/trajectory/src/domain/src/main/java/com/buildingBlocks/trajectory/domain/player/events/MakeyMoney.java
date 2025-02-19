package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Diner;
import com.buildingBlocks.trajectory.domain.player.values.Salary;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class MakeyMoney extends DomainEvent {

    private final Diner amount;
    private Salary salary = null;

    public MakeyMoney(Diner amount){
        super(EventsNameEnum.MAKEY_MONEY.name());
        this.amount = amount;
        this.salary = salary;
    }

    public Diner getAmount() {
        return amount;
    }

    public Salary getSalary() {
        return salary;
    }

}