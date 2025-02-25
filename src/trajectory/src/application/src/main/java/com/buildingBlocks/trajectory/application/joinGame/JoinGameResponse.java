package com.buildingBlocks.trajectory.application.joinGame;

import java.util.ArrayList;
import java.util.List;

public class JoinGameResponse {
    private final String name;
    private final String message;

    public JoinGameResponse(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    //    private final String gameId;
//    private final List<Players> players;
//    private final Integer BoardPosition;

//    public JoinGameResponse(String gameId, Integer boardPosition) {
//        this.gameId = gameId;
////        this.players = players;
//        this.BoardPosition = boardPosition;
//    }
//
//    //region getters
//    public String getGameId() {
//        return gameId;
//    }
//
////    public List<Players> getPlayers() {
////        return players;
////    }
//
//    public Integer getBoardPosition() {
//        return BoardPosition;
//    }




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


