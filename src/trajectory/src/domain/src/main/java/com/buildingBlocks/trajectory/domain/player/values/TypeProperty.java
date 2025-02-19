package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class TypeProperty implements IValueObject {
    private final TypePropertyEnum typeProperty;

    public TypeProperty(TypePropertyEnum typeProperty){
        this.typeProperty = typeProperty;
        validate();
    }

    public static TypeProperty of(TypePropertyEnum typeProperty){
        return new TypeProperty(typeProperty);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotBlank(String.valueOf(typeProperty), "el tipo de propiedad no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(typeProperty), "el tipo de propiedad no puede ser null");
        ValidateUtils.validateIsString(String.valueOf(typeProperty), "el tipo de propiedad no puede ser un numero");
    }

    public TypePropertyEnum getTypeProperty() {
        return typeProperty;
    }
}