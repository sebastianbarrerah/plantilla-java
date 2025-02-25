package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AcquiredProperty extends DomainEvent {

        private String address;
        private Integer value;
        private String type;

        public AcquiredProperty(){
            super(EventsNameEnum.ACQUIRED_PROPERTY.name());
        }

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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    //endregion
}