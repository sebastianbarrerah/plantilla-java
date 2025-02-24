package com.buildingBlocks.trajectory.application.joinGame;

import com.buildingblock.shared.application.Request;

import java.util.ArrayList;
import java.util.List;

public class JoinGameRequest extends Request {

    private final String playerName;
    private final List<String> cards;

    public JoinGameRequest( String playerName) {
        super(null);
        this.playerName = playerName;
        this.cards = new ArrayList<>();
    }

    //region getters
    public String getPlayerName() {
        return playerName;
    }

    public List<String> getCards() {
        return cards;
    }
    //endregion
}
