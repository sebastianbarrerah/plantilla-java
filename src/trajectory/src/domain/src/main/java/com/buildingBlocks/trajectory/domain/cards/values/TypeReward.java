package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEffectEnum;
import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class TypeReward implements IValueObject {
    private final TypeEventEffectEnum typeReward;

    private TypeReward(TypeEventEffectEnum typeReward){
        this.typeReward = typeReward;
        validate();
    }

    public static TypeReward of(TypeEventEffectEnum typeReward){
        return new TypeReward(typeReward);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(typeReward, "el tipo de recompensa no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(typeReward), "el tipo de recompensa no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(typeReward), "el tipo de recompensa es requerido");
        ValidateUtils.validateIsString(String.valueOf(typeReward), "el tipo de recompensa no puede ser un numero");
    }

    public TypeEventEffectEnum getTypeReward() {
        return typeReward;
    }

}