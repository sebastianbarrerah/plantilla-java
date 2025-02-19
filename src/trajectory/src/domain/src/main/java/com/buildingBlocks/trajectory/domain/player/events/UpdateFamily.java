package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Children;
import com.buildingBlocks.trajectory.domain.player.values.Coupe;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateFamily extends DomainEvent {
    private final Children children;
    private final Coupe coupe;

    public UpdateFamily(Children children, Coupe coupe){
        super(EventsNameEnum.UPDATE_FAMILY.name());
        this.children = children;
        this.coupe = coupe;
    }

    public Children getChildren() {
        return children;
    }

    public Coupe getCoupe() {
        return coupe;
    }
}