package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class TypeDecision implements IValueObject {
    private final TypeEventEffectEnum typeDecision;

    private TypeDecision(TypeEventEffectEnum typeDecision){
        this.typeDecision = typeDecision;
        validate();
    }

    public static TypeDecision of(TypeEventEffectEnum typeDecision){
        return new TypeDecision(typeDecision);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(typeDecision, "el tipo de decisión no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(typeDecision), "el tipo de decisión no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(typeDecision), "el tipo de decisión es requerido");
        ValidateUtils.validateIsString(String.valueOf(typeDecision), "el tipo de decisión no puede ser un numero");
    }

    public TypeEventEffectEnum getTypeDecision() {
        return typeDecision;
    }
}