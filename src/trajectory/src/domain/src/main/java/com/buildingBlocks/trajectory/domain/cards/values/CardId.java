package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class CardId extends Identity {
    public CardId(){
        super();
    }

    private CardId(String id){
        super(id);
    }

    public static CardId of(String id){
        return new CardId(id);
    }
}
