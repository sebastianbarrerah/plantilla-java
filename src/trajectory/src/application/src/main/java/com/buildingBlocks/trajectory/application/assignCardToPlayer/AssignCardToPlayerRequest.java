package com.buildingBlocks.trajectory.application.assignCardToPlayer;

import com.buildingblock.shared.application.Request;

public class AssignCardToPlayerRequest extends Request {
    private final String type;
    private final String effect;


    protected AssignCardToPlayerRequest(String type, String effect) {
        super(null);
        this.type = type;
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }

}
