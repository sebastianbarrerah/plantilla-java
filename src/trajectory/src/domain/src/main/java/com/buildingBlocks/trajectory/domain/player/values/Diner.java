package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Diner implements IValueObject {
    private final Integer amount;

    public Diner(Integer amount){
        this.amount = amount;
        validate();
    }

    public static Diner of(Integer amount){
        return new Diner(amount);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotBlank(String.valueOf(amount), "el dinero no puede estar vacio");
        ValidateUtils.validateMaxLength(String.valueOf(amount), 1000, "el dinero no puede ser mayor a 1000");
    }

    public Integer getAmount() {
        return amount;
    }
}