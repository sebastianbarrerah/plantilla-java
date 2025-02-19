package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class BoardPosition implements IValueObject {
    private final int numberPosition;

    private BoardPosition(int numberPosition){
        this.numberPosition = numberPosition;
        validate();
    }

    public static BoardPosition of(int numberPosition){
        return new BoardPosition(numberPosition);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsPositive(numberPosition, "el numero de posicion debe ser valido");
        ValidateUtils.validateMaxLength(String.valueOf(numberPosition), 300, "el numero de posicion no debe ser mayor a 300");
    }

    public int getNumberPosition() {
        return numberPosition;
    }
}