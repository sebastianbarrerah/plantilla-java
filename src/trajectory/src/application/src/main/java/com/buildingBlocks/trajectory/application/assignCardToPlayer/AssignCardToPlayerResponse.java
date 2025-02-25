package com.buildingBlocks.trajectory.application.assignCardToPlayer;

public class AssignCardToPlayerResponse {
    private final String typeCard;
    private final String effectCard;
    private final String message;

    public AssignCardToPlayerResponse(String typeCard, String effectCard, String message) {
        this.typeCard = typeCard;
        this.effectCard = effectCard;
        this.message = message;

    }

    public String getTypeCard() {
        return typeCard;
    }

    public String getEffectCard() {
        return effectCard;
    }

    public String getMessage() {
        return message;
    }

}
