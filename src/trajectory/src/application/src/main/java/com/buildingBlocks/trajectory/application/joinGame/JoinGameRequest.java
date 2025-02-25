package com.buildingBlocks.trajectory.application.joinGame;

import com.buildingblock.shared.application.Request;


public class JoinGameRequest extends Request {

    private String playerName;

    public JoinGameRequest() {
        super(null);
    }

    public JoinGameRequest(String playerName) {
        super(null);
        this.playerName = playerName;
    }

    //region getters
    public String getPlayerName() {
        return playerName;
    }

    //endregion
}
