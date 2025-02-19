package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.State;
import com.buildingBlocks.trajectory.domain.player.values.StatePlayerEnum;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class StateChange extends DomainEvent {

    private StatePlayerEnum state = null;

    public StateChange(StatePlayerEnum state){
        super(EventsNameEnum.STATE_CHANGE.name());
        this.state = this.state;
    }

    public State getState() {
        return state;
    }

}