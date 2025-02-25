package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Name implements IValueObject {

    private final String name;

    private Name(String name){
        this.name = name;
        validate();
    }

    public static Name of(String name){
        return new Name(name);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotEmpty(name, "el nombre no puede estar vacio");
    }

    public String getName() {
        return name;
    }

}