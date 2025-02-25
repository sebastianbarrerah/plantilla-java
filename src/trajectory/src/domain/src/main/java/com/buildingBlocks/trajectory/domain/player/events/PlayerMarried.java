package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerMarried extends DomainEvent {
    private Boolean isMarried;

    public PlayerMarried(){
        super(EventsNameEnum.PLAYER_MARRIED.name());
    }

    public PlayerMarried(Boolean isMarried){
        super(EventsNameEnum.PLAYER_MARRIED.name());
        this.isMarried = isMarried;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }
}
