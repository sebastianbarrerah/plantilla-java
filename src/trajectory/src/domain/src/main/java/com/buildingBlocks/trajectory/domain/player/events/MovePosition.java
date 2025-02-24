package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class MovePosition extends DomainEvent {
    private final Integer position;

    public MovePosition(Integer position) {
        super(EventsNameEnum.MOVE_IN_POSITION.name());
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }
}