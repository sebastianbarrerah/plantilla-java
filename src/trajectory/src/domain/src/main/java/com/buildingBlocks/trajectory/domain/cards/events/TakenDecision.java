package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class TakenDecision extends DomainEvent {

    private final String id;
    private final String nameDecision;
    private final String descriptionDecision;
    private final StateEvent state;
    private final TypeEvent type;
    private final ValueDecision value;

    public TakenDecision(String id, String nameDecision, String descriptionDecision, StateEvent state, TypeEvent type, ValueDecision value){
        super(NameEventsListEnum.TAKEN_DECISION.name());
        this.id = id;
        this.nameDecision = nameDecision;
        this.descriptionDecision = descriptionDecision;
        this.state = state;
        this.type = type;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getNameDecision() {
        return nameDecision;
    }

    public String getDescriptionDecision() {
        return descriptionDecision;
    }

    public StateEvent getState() {
        return state;
    }

    public TypeEvent getType() {
        return type;
    }

    public ValueDecision getValue() {
        return value;
    }
}