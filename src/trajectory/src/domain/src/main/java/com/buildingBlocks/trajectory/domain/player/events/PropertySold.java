package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PropertySold extends DomainEvent {
    private String address;
    private Integer value;
    private String type;

    public PropertySold(String address, Integer value, String type){
        super(EventsNameEnum.PROPERTY_SOLD.name());
        this.address = address;
        this.value = value;
        this.type = type;
    }

    //region getters and setters
    public String getAddress() {
        return address;
    }


    //endregion
}