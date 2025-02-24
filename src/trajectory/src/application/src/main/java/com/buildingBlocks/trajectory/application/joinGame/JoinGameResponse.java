package com.buildingBlocks.trajectory.application.joinGame;

import java.util.ArrayList;
import java.util.List;

public class JoinGameResponse {
    private final String gameId;
    private final List<Players> players;
    private final Integer BoardPosition;
    private final List<CardsMazo> cardsMazo;

    public JoinGameResponse(String gameId, List<Players> players, Integer boardPosition) {
        this.gameId = gameId;
        this.players = players;
        this.BoardPosition = boardPosition;
        this.cardsMazo = new ArrayList<>();
    }

    //region getters
    public String getGameId() {
        return gameId;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public Integer getBoardPosition() {
        return BoardPosition;
    }


    public List<CardsMazo> getCardsMazo() {
        return cardsMazo;
    }
    //endregion
}


 class Players {
    private final String name;
    private final List<String> cards;
    private final Integer money;
    private final Integer Position;

    public Players(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.money = 0;
        this.Position = 0;

    }

    public String getName() {
        return name;
    }

    public List<String> getCards() {
        return cards;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getPosition() {
        return Position;
    }
}

 class CardsMazo {
    private final String name;
    private final String effect;

    public CardsMazo(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
