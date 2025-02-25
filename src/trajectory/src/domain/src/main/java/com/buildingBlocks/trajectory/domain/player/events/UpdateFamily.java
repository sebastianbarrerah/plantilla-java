package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateFamily extends DomainEvent {
    private Integer children;

    public UpdateFamily(Integer children){
        super(EventsNameEnum.UPDATE_FAMILY.name());
        this.children = children;
    }

    public UpdateFamily(){
        super(EventsNameEnum.UPDATE_FAMILY.name());
    }

    //region getters and setters
    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    //endregion
}