package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class EffectCard implements IValueObject {
    private final String question;

    private EffectCard(String question){
        this.question = question;
        validate();
    }

    public static EffectCard of(String question){
        return new EffectCard(question);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotBlank(question, "el efecto no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(question, "el efecto es requerido");
        ValidateUtils.validateIsString(question, "el efecto no puede ser un numero");
        ValidateUtils.validateIsNotNull(question, "el efecto no puede ser null");
    }


}