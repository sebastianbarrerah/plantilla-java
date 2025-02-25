package com.buildingBlocks.trajectory.domain.cards.events;

import com.buildingBlocks.trajectory.domain.cards.values.StateEvent;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEvent;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class GroupImpact extends DomainEvent {
    private String type;
    private String state;
    private Integer value;

    public GroupImpact(){
        super(NameEventsListEnum.GROUP_IMPACT.name());
    }

    public GroupImpact(String type, String state, Integer value){
        super(NameEventsListEnum.GROUP_IMPACT.name());
        this.type = type;
        this.state = state;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public Integer getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}