package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerCreated extends DomainEvent {

    private final String name;
    private final Integer InitalPosition = 0;
    private final Integer InitalMoney = 0;

    public PlayerCreated(String name) {
        super(EventsNameEnum.PLAYER_CREATED.name());
        this.name = name;
    }

    //region getters and setters
    @Override
    public String getName() {
        return name;
    }

    public Integer getInitalPosition() {
        return InitalPosition;
    }

    public Integer getInitalMoney() {
        return InitalMoney;
    }
    //endregion
}
