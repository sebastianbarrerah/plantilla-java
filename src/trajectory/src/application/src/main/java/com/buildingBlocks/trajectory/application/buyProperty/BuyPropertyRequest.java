package com.buildingBlocks.trajectory.application.buyProperty;

import com.buildingblock.shared.application.Request;

public class BuyPropertyRequest extends Request {
    private final String address;
    private final Integer value;
    private final String type;

    public BuyPropertyRequest(String aggregateId, String address, Integer value, String type) {
        super(aggregateId);
        this.address = address;
        this.value = value;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
