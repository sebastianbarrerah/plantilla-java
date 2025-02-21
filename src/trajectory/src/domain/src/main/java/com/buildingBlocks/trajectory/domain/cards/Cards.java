package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Consequence;
import com.buildingBlocks.trajectory.domain.cards.entities.Decision;
import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.CancelledEvent;
import com.buildingBlocks.trajectory.domain.cards.events.GroupImpact;
import com.buildingBlocks.trajectory.domain.cards.events.IsRewarded;
import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
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
        subscribe(new CardsHandler(this));
    }

    private Cards(CardId Identity){
        super(new CardId());
        subscribe(new CardsHandler(this));
    }



    public void assignReward(String name, String description, String value, String state, String type) {
        apply(new IsRewarded(name, description, state, type, value));
    }



    public List<Reward> getRewards() {
        return rewards;
    }


    public void setState(StateEvent state) {
    }
}
