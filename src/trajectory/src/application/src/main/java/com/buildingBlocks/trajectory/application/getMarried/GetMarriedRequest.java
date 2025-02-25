package com.buildingBlocks.trajectory.application.getMarried;

import com.buildingblock.shared.application.Request;

public class GetMarriedRequest extends Request {
    private Boolean isMarried;

    public GetMarriedRequest() {
        super(null);
    }

    public GetMarriedRequest( Boolean isMarried) {
        super(null);
        this.isMarried = isMarried;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }


}
