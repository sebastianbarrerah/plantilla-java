package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Address implements IValueObject {

    private final String street;

    public Address(String street){
        this.street = street;
        validate();
    }

    public static Address of(String street){
        return new Address(street);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotBlank(street, "street no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(street, "street no puede ser null");
    }

    public String getStreet() {
        return street;
    }

}