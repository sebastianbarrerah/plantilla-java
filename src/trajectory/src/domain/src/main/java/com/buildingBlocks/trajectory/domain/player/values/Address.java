package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Address implements IValueObject {

    private final String street;
    private final String number;
    private final String zone;

    public Address(String street, String number, String zone){
        this.street = street;
        this.number = number;
        this.zone = zone;
        validate();
    }

    public static Address of(String street, String number, String zone){
        return new Address(street, number, zone);
    }

   @Override
    public void validate() {
        ValidateUtils.validateIsNotBlank(street, "street no puede estar vacio");
        ValidateUtils.validateIsNotBlank(zone, "la zona es requerida");
        ValidateUtils.validateIsNotEmpty(street, "street no puede ser null");
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZone() {
        return zone;
    }
}