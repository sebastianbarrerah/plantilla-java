package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Salary implements IValueObject {
    private final long amount;

    private Salary(long amount){
        this.amount = amount;
        validate();
    }

    public static Salary of(long amount){
        return new Salary(amount);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsPositive((int) amount, "La cantidad de dinero debe ser valida");
        ValidateUtils.validateIsNotNull(amount, "el dinero no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(amount), "el dinero no puede estar vacio");
        ValidateUtils.validateMaxLength(String.valueOf(amount), 10000, "el dinero no puede ser mayor a 10000");
    }

    public long getAmount() {
        return amount;
    }
}