package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class State implements IValueObject {
    private final StatePlayerEnum statePlayer;

    private State(StatePlayerEnum statePlayer){
        this.statePlayer = statePlayer;
        validate();
    }

    public static State of(StatePlayerEnum statePlayer){
        return new State(statePlayer);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(statePlayer, "el estado no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(statePlayer), "el estado no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(statePlayer), "el estado es requerido");
    }

    public StatePlayerEnum getStatePlayer() {
        return statePlayer;
    }
}