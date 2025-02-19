package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class QuantityReward implements IValueObject {
    private final int quantity;

    private QuantityReward(int quantity){
        this.quantity = quantity;
        validate();
    }

    public static QuantityReward of(int quantity){
        return new QuantityReward(quantity);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsPositive(quantity, "la cantidad de recompensa debe ser valida");
        ValidateUtils.validateIsNotNull(quantity, "la cantidad de recompensa no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(quantity), "la cantidad de recompensa no puede estar vacio");
        ValidateUtils.validateMaxLength(String.valueOf(quantity), 10000, "la cantidad de recompensa no puede ser mayor a 10000");
    }

    public int getQuantity() {
        return quantity;
    }
}