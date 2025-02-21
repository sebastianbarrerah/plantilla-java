package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StateEvent that = (StateEvent) o;
        return stateEvent == that.stateEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stateEvent);
    }

    public StateEventEnum getStateEvent() {
        return stateEvent;
    }
}