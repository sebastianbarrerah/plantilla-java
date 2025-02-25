package com.buildingBlocks.trajectory.application.getCards;

import java.util.List;

public class GetCardsResponse {
    private List<String> cards;
    private String message;

    public GetCardsResponse(String message) {
        this.message = message;
    }

    public GetCardsResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
