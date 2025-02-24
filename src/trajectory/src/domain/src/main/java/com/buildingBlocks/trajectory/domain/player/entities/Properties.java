package com.buildingBlocks.trajectory.domain.player.entities;

import com.buildingBlocks.trajectory.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Properties extends Entity<PlayerId> {
    private TypeProperty type;
    private Diner value;
    private Address address;

    public Properties(TypeProperty type, Diner value, Address address){
        super(new PlayerId());
        this.type = type;
        this.value = value;
        this.address = address;
    }

    public Properties(Identity id, TypeProperty type, Diner value, Address address){
        super((PlayerId) id);
        this.type = type;
        this.value = value;
        this.address = address;
    }

    //region getters and setters
    public TypeProperty getType() {
        return type;
    }

    public void setType(TypeProperty type) {
        this.type = type;
    }

    public Diner getValue() {
        return value;
    }

    public void setValue(Diner value) {
        this.value = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //endregion
}