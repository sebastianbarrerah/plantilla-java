package com.buildingBlocks.trajectory.application.getMarried;

public class GetMarriedResponse {
    private final String playerName;
    private final Integer money;
    private final Integer position;
    private final String message;

    public GetMarriedResponse(String playerName, Integer money, Integer position, String message) {
        this.playerName = playerName;
        this.money = money;
        this.position = position;
        this.message = message;
    }



    public String getPlayerName() {
        return playerName;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getPosition() {
        return position;
    }

    public String getMessage() {
        return message;
    }
}
