package com.buildingBlocks.trajectory.application.discardCard;

public class DiscardCardResponse {
    private final String playerId;
    private final String cardName;
    private final String cardEffect;

    public DiscardCardResponse(String playerId, String cardName, String cardEffect) {
        this.playerId = playerId;
        this.cardName = cardName;
        this.cardEffect = cardEffect;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardEffect() {
        return cardEffect;
    }
}
