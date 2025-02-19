package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEnum;
import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class TypeEvent implements IValueObject {
    private final TypeEventEnum typeEvent;

    private TypeEvent(TypeEventEnum typeEvent){
        this.typeEvent = typeEvent;
        validate();
    }

    public static TypeEvent of(TypeEventEnum typeEvent){
        return new TypeEvent(typeEvent);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(typeEvent, "el tipo de evento no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(typeEvent), "el tipo de evento no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(typeEvent), "el tipo de evento es requerido");
        ValidateUtils.validateIsString(String.valueOf(typeEvent), "el tipo de evento no puede ser un numero");
    }

    public TypeEventEnum getTypeEvent() {
        return typeEvent;
    }

}