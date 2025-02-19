package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Coupe implements IValueObject {
    private final boolean isCoupe;

    private Coupe(boolean isCoupe){
        this.isCoupe = isCoupe;
        validate();
    }

    public static Coupe of(boolean isCoupe){
        return new Coupe(isCoupe);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(isCoupe, "el valor de la coupe no puede ser null");
    }

    public boolean getIsCoupe() {
        return isCoupe;
    }
}