package com.buildingBlocks.trajectory.domain.cards.events;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class IsRewarded extends DomainEvent {

    private String nameReward;
    private String descriptionReward;
    private String type;
    private Integer value;

    public IsRewarded(){
        super(NameEventsListEnum.IS_REWARDED.name());
    }

    public String getNameReward() {
        return nameReward;
    }

    public String getType() {
        return type;
    }

    public IsRewarded( String nameReward, String descriptionReward,String type, Integer value){
        super(NameEventsListEnum.IS_REWARDED.name());
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.type = type;
        this.value = value;
    }

    public String getDescriptionReward() {
        return descriptionReward;
    }

    public Integer getValue() {
        return value;
    }

    public void setNameReward(String nameReward) {
        this.nameReward = nameReward;
    }

    public void setDescriptionReward(String descriptionReward) {
        this.descriptionReward = descriptionReward;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}