package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Consequence;
import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.*;
import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class Cards extends AggregateRoot<CardId> {

    private Consequence consequence;
    private List<Reward> rewards = new ArrayList<>();
    private List<Card> listCards = new ArrayList<>();
    private TypeEvent type;

    //region constructores
    public Cards() {
        super(new CardId());
        subscribe(new CardsHandler(this));
    }

    private Cards(CardId Identity){
        super(new CardId());
        subscribe(new CardsHandler(this));
    }
    //endregion

    //region getters and setters


    public List<Reward> getRewards() {
        return rewards;
    }


    public List<Card> getListCards() {
        return listCards;
    }


    public TypeEvent getType() {
        return type;
    }

    public void setType(TypeEvent type) {
        this.type = type;
    }
    //endregion


    //region acciones
    public void cardApplied(String type, String effect) {
        apply(new CardApplied(type, effect));
    }

    public void cardDiscarded(String type, String state) {
        apply(new CardDiscarded(type, state));
    }

    public void groupImpact(String type, String state, Integer value) {
        apply(new GroupImpact(type, state, value));
    }

    public void isRewarded(String nameReward, String descriptionReward, String type, Integer value) {
        apply(new IsRewarded(nameReward, descriptionReward, type, value));
    }

    public void listCards() {
        apply(new ListCards());
    }

    //endregion


    //region metodo de recontruccion
    public static Cards from(final String identity, final List<DomainEvent> events) {
        Cards cards = new Cards(CardId.of(identity));
        events.forEach(cards::apply);
        return cards;
    }
    //endregion



}
