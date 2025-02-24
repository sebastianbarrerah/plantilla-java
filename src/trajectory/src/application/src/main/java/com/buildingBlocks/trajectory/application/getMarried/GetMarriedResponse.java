package com.buildingBlocks.trajectory.application.getMarried;

public class GetMarriedResponse {
    private final String playerName;
    private final Integer money;
    private final Integer position;

    public GetMarriedResponse( String playerName, Integer money, Integer position) {
        this.playerName = playerName;
        this.money = money;
        this.position = position;
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
}
