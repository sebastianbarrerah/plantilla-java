package com.buildingBlocks.trajectory.domain.cards.entities;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;


public class Decision extends Entity<CardId> {
    private NameDecision nameDecision;
    private DescriptionDecision descriptionDecision;
    private TypeEvent type;
    private ValueDecision value;
    private EffectCard effectCard;

    public Decision(NameDecision nameDecision, DescriptionDecision descriptionDecision, TypeEvent type, ValueDecision value, EffectCard effectCard){
        super(new CardId());
        this.nameDecision = nameDecision;
        this.descriptionDecision = descriptionDecision;
        this.type = type;
        this.value = value;
        this.effectCard = effectCard;
    }

    public Decision(Identity id, NameDecision nameDecision, DescriptionDecision descriptionDecision, TypeEvent type, ValueDecision value, EffectCard effectCard){
        super((CardId) id);
        this.nameDecision = nameDecision;
        this.descriptionDecision = descriptionDecision;
        this.type = type;
        this.value = value;
        this.effectCard = effectCard;
    }



    public NameDecision getNameDecision() {
        return nameDecision;
    }

    public void setNameDecision(NameDecision nameDecision) {
        this.nameDecision = nameDecision;
    }

    public DescriptionDecision getDescriptionDecision() {
        return descriptionDecision;
    }

    public void setDescriptionDecision(DescriptionDecision descriptionDecision) {
        this.descriptionDecision = descriptionDecision;
    }

    public ValueDecision getValue() {
        return value;
    }

    public void setValue(ValueDecision value) {
        this.value = value;
    }

    public TypeEvent getType() {
        return type;
    }

    public void setType(TypeEvent type) {
        this.type = type;
    }

    public EffectCard getQuestion() {
        return effectCard;
    }

    public void setQuestion(EffectCard effectCard) {
        this.effectCard = effectCard;
    }
}