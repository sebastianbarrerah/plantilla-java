package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerCreated extends DomainEvent {

    private String namePlayerCreated;
    private Integer InitalPosition = 0;
    private Integer InitalMoney = 0;

    public PlayerCreated(){
        super(EventsNameEnum.PLAYER_CREATED.name());
    }

    public PlayerCreated(String name) {
        super(EventsNameEnum.PLAYER_CREATED.name());
        this.namePlayerCreated = name;
    }


    //region getters and setters

    public String getNamePlayerCreated() {
        return namePlayerCreated;
    }

    public void setNamePlayerCreated(String namePlayerCreated) {
        this.namePlayerCreated = namePlayerCreated;
    }

    public Integer getInitalPosition() {
        return InitalPosition;
    }

    public void setInitalPosition(Integer initalPosition) {
        InitalPosition = initalPosition;
    }

    public Integer getInitalMoney() {
        return InitalMoney;
    }

    public void setInitalMoney(Integer initalMoney) {
        InitalMoney = initalMoney;
    }


    //endregion
}
