package com.buildingBlocks.trajectory.domain.cards.entities;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Reward extends Entity<CardId> {

    private final NameReward nameReward;
    private final DescriptionReward descriptionReward;
    private final TypeReward typeReward;
    private final Integer valueReward;

    public Reward(NameReward nameReward, DescriptionReward descriptionReward, TypeReward typeReward, Integer valueReward){
        super(new CardId());
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }

    public Reward(Identity id, NameReward nameReward, DescriptionReward descriptionReward, TypeReward typeReward, Integer valueReward){
        super((CardId) id);
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }



    public NameReward getNameReward() {
        return nameReward;
    }

    public DescriptionReward getDescriptionReward() {
        return descriptionReward;
    }

    public TypeReward getTypeReward() {
        return typeReward;
    }

    public Integer getValueReward() {
        return valueReward;
    }

    public Reward(String nameReward, String descriptionReward, String value, NameReward nameReward1, DescriptionReward descriptionReward1, TypeReward typeReward, Integer valueReward) {
        super(new CardId());
        this.nameReward = nameReward1;
        this.descriptionReward = descriptionReward1;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }



}