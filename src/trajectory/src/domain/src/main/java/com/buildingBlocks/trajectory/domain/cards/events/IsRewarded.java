package com.buildingBlocks.trajectory.domain.cards.events;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class IsRewarded extends DomainEvent {

    private final String nameReward;
    private final String descriptionReward;
    private final String type;
    private final Integer value;

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
}