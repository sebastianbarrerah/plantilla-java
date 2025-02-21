package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Address;
import com.buildingBlocks.trajectory.domain.player.values.Diner;
import com.buildingBlocks.trajectory.domain.player.values.TypeProperty;
import com.buildingBlocks.trajectory.domain.player.values.ValueProperty;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AcquiredProperty extends DomainEvent {

        private final Address address;
        private final Diner value;
        private final TypeProperty type;

    public AcquiredProperty(Address address, Diner value, TypeProperty type){
        super(EventsNameEnum.ACQUIRED_PROPERTY.name());
        this.address = address;
        this.value = value;
        this.type = type;
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