package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AcquiredProperty extends DomainEvent {

        private final String address;
        private final Integer value;
        private final String type;

    public AcquiredProperty(String address, Integer value, String type){
        super(EventsNameEnum.ACQUIRED_PROPERTY.name());
        this.address = address;
        this.value = value;
        this.type = type;
    }

    //region getters and setters
    public String getAddress() {
        return address;
    }

    public Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
    //endregion
}