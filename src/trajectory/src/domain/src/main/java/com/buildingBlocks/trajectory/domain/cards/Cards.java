package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Consequence;
import com.buildingBlocks.trajectory.domain.cards.entities.Decision;
import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.*;
import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainActionsHandler;

import java.util.ArrayList;
import java.util.List;

public class Cards extends AggregateRoot<CardId> {

    private Consequence consequence;
    private Decision decision;
    private List<Reward> rewards = new ArrayList<>();
    private TypeEvent type;
    private StateEvent state;

    public Cards() {
        super(new CardId());
        DomainActionsHandler.subscribe(new CardsHandler(this));

        this.type = TypeEvent.DECISION;
        this.state = StateEvent.ACTIVE;

        apply(new CancelledEvent(id.getId(), type, state));
        apply(new GroupImpact(type, state, "ImpactoEjemplo"));
        apply(new IsRewarded(id.getId(), "RecompensaEjemplo", "Descripción de recompensa", state, type, "100"));
        apply(new TakenDecision(id.getId(), "DecisiónEjemplo", "Descripción decisión", state, type, new ValueDecision(50L)));
    }

    private Cards(CardId Identity){
        super(Identity);
        DomainActionsHandler.subscribe(new CardsHandler(this));
    }

    public Consequence getConsequence() {
        return consequence;
    }

    public void setConsequence(Consequence consequence) {
        this.consequence = consequence;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public TypeEvent getType() {
        return type;
    }

    public void setType(TypeEvent type) {
        this.type = type;
    }

    public StateEvent getState() {
        return state;
    }

    public void setState(StateEvent state) {
        this.state = state;
    }

    public void validateStateOfCard(String id) {
        if (id.equals(this.id.getId()) && this.state == StateEvent.COMPLETED) {
            throw new IllegalArgumentException("Estado de la tarjeta no puede ser COMPLETADO");
        }
    }
}
