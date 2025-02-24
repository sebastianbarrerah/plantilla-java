package com.buildingBlocks.trajectory.domain.cards.entities;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Reward extends Entity<CardId> {

    private final String nameReward;
    private final String descriptionReward;
    private final String typeReward;
    private final Integer valueReward;

    public Reward(String nameReward, String descriptionReward, String typeReward, Integer valueReward){
        super(new CardId());
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }

    public Reward(Identity id, String nameReward, String descriptionReward, String typeReward, Integer valueReward){
        super((CardId) id);
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }


    public String getNameReward() {
        return nameReward;
    }

    public String getDescriptionReward() {
        return descriptionReward;
    }

    public String getTypeReward() {
        return typeReward;
    }

    public Integer getValueReward() {
        return valueReward;
    }
}