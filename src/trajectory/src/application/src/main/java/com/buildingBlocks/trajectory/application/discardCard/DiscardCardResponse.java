package com.buildingBlocks.trajectory.application.discardCard;

public class DiscardCardResponse {
    private final String cardName;
    private final String cardEffect;
    private final String message;

    public DiscardCardResponse( String cardName, String cardEffect, String message) {
        this.cardName = cardName;
        this.cardEffect = cardEffect;
        this.message = message;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardEffect() {
        return cardEffect;
    }

    public String getMessage() {
        return message;
    }
}
