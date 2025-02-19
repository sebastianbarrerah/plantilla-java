package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class StateEvent implements IValueObject {
    private final StateEventEnum stateEvent;

    private StateEvent(StateEventEnum stateEvent){
        this.stateEvent = stateEvent;
        validate();
    }

    public static StateEvent of(StateEventEnum stateEvent){
        return new StateEvent(stateEvent);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(stateEvent, "el estado del evento no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(stateEvent), "el estado del evento no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(stateEvent), "el estado del evento es requerido");
    }

    public StateEventEnum getStateEvent() {
        return stateEvent;
    }
}