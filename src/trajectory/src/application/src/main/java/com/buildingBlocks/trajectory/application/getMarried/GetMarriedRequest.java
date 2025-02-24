package com.buildingBlocks.trajectory.application.getMarried;

import com.buildingblock.shared.application.Request;

public class GetMarriedRequest extends Request {
    private final Boolean IsMarried;

    public GetMarriedRequest(String aggregateId, Boolean IsMarried) {
        super(aggregateId);
        this.IsMarried = IsMarried;
    }

    public Boolean getIsMarried() {
        return IsMarried;
    }


}
