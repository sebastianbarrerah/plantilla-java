package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Address;
import com.buildingBlocks.trajectory.domain.player.values.Diner;
import com.buildingBlocks.trajectory.domain.player.values.TypeProperty;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PropertySold extends DomainEvent {
    private final String id;
    private final Address address;
    private final Diner value;
    private final TypeProperty type;

    public PropertySold(String id, Address address, Diner value, TypeProperty type){
        super(EventsNameEnum.PROPERTY_SOLD.name());
        this.id = id;
        this.address = address;
        this.value = value;
        this.type = type;

    }



    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Diner getValue() {
        return value;
    }

    public TypeProperty getType() {
        return type;
    }
}