package com.buildingBlocks.trajectory.domain.player.entities;

import com.buildingBlocks.trajectory.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Properties extends Entity<PlayerId> {
    private String id;
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


    public String getId() {
        return id;
    }

    public TypeProperty getType() {
        return type;
    }

    public Diner getValue() {
        return value;
    }

    public Address getAddress() {
        return address;
    }


}