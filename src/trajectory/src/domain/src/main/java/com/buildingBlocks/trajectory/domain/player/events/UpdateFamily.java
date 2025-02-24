package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateFamily extends DomainEvent {
    private final Integer children;

    public UpdateFamily(Integer children){
        super(EventsNameEnum.UPDATE_FAMILY.name());
        this.children = children;
    }

    //region getters and setters
    public Integer getChildren() {
        return children;
    }

    //endregion
}