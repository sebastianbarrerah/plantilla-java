package com.buildingBlocks.trajectory.application.assignCardToPlayer;

public class AssignCardToPlayerResponse {
    private final String typeCard;
    private final String effectCard;

    public AssignCardToPlayerResponse(String typeCard, String effectCard) {
        this.typeCard = typeCard;
        this.effectCard = effectCard;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public String getEffectCard() {
        return effectCard;
    }

}
