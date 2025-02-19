package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.Address;
import com.buildingBlocks.trajectory.domain.player.values.TypeProperty;
import com.buildingBlocks.trajectory.domain.player.values.ValueProperty;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AcquiredProperty extends DomainEvent {

        private final Address address;
        private final ValueProperty value;
        private final TypeProperty type;

    public AcquiredProperty(Address address, ValueProperty value, TypeProperty type){
        super(EventsNameEnum.ACQUIRED_PROPERTY.name());
        this.address = address;
        this.value = value;
        this.type = type;
    }


    public Address getAddress() {
        return address;
    }

    public ValueProperty getValue() {
        return value;
    }

    public TypeProperty getType() {
        return type;
    }


}