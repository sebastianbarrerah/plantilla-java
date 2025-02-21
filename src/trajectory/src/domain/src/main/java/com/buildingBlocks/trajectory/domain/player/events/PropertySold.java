package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.TypePropertyEnum;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PropertySold extends DomainEvent {
    private String id;
    private String address;
    private Integer value;
    private TypePropertyEnum type;

    public PropertySold(String id, String address, Integer value, TypePropertyEnum type){
        super(EventsNameEnum.PROPERTY_SOLD.name());
        this.id = id;
        this.address = address;
        this.value = value;
        this.type = type;
    }



    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Integer getValue() {
        return value;
    }

    public TypePropertyEnum getType() {
        return type;
    }
}