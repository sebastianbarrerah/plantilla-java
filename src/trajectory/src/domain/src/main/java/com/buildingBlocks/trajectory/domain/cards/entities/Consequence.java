package com.buildingBlocks.trajectory.domain.cards.entities;

import com.buildingBlocks.trajectory.domain.cards.events.GroupImpact;
import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;


public class Consequence extends Entity<CardId> {

    private NameConsequence nameConsequence;
    private DescriptionConsequence descriptionConsequence;
    private TypeEvent type;
    private ValueConsequence value;

    public Consequence(NameConsequence nameConsequence, DescriptionConsequence descriptionConsequence, TypeEvent type, ValueConsequence value){
        super(new CardId());
        this.nameConsequence = nameConsequence;
        this.descriptionConsequence = descriptionConsequence;
        this.type = type;
        this.value = value;
    }

    public Consequence(Identity id, NameConsequence nameConsequence, DescriptionConsequence descriptionConsequence, TypeEvent type, ValueConsequence value){
        super((CardId) id);
        this.nameConsequence = nameConsequence;
        this.descriptionConsequence = descriptionConsequence;
        this.type = type;
        this.value = value;
    }


    public DescriptionConsequence getDescriptionConsequence() {
        return descriptionConsequence;
    }

    public void setDescriptionConsequence(DescriptionConsequence descriptionConsequence) {
        this.descriptionConsequence = descriptionConsequence;
    }

    public NameConsequence getNameConsequence() {
        return nameConsequence;
    }

    public void setNameConsequence(NameConsequence nameConsequence) {
        this.nameConsequence = nameConsequence;
    }

    public TypeEvent getType() {
        return type;
    }

    public void setType(TypeEvent type) {
        this.type = type;
    }

    public ValueConsequence getValue() {
        return value;
    }

    public void setValue(ValueConsequence value) {
        this.value = value;
    }
}