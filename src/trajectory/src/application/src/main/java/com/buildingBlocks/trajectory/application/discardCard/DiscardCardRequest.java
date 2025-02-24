package com.buildingBlocks.trajectory.application.discardCard;

import com.buildingblock.shared.application.Request;

public class DiscardCardRequest extends Request {
    private final String typeCard;
    private final String stateCard;


    public DiscardCardRequest(String aggregateId, String typeCard, String stateCard) {
        super(aggregateId);
        this.typeCard = typeCard;
        this.stateCard = stateCard;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public String getStateCard() {
        return stateCard;
    }
}
