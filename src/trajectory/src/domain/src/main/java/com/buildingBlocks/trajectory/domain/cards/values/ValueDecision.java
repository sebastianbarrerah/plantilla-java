package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class ValueDecision implements IValueObject {
    private final Long value;

    public ValueDecision(Long value){
        this.value = value;
        validate();
    }

    public static ValueDecision of(Long value){
        return new ValueDecision(value);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsPositive(Math.toIntExact(value), "el valor de la decisión debe ser valida");
        ValidateUtils.validateIsNotNull(value, "el valor de la decisión no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(value), "el valor de la decisión no puede estar vacio");
        ValidateUtils.validateMaxLength(String.valueOf(value), 10000, "el valor de la decisión no puede ser mayor a 10000");
    }

    public Long getValue() {
        return value;
    }

}