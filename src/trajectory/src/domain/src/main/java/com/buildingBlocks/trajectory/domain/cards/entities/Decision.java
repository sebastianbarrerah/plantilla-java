package com.buildingBlocks.trajectory.domain.cards.entities;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;


public class Decision extends Entity<CardId> {
    private NameDecision nameDecision;
    private DescriptionDecision descriptionDecision;
    private TypeEvent type;
    private ValueDecision value;
    private Question question;

    public Decision(NameDecision nameDecision, DescriptionDecision descriptionDecision, TypeEvent type, ValueDecision value, Question question){
        super(new CardId());
        this.nameDecision = nameDecision;
        this.descriptionDecision = descriptionDecision;
        this.type = type;
        this.value = value;
        this.question = question;
    }

    public Decision(Identity id, NameDecision nameDecision, DescriptionDecision descriptionDecision, TypeEvent type, ValueDecision value, Question question){
        super((CardId) id);
        this.nameDecision = nameDecision;
        this.descriptionDecision = descriptionDecision;
        this.type = type;
        this.value = value;
        this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}