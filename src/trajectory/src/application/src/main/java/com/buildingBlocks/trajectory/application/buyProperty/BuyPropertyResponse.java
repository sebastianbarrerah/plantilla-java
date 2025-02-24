package com.buildingBlocks.trajectory.application.buyProperty;

public class BuyPropertyResponse {
    private final String address;
    private final Integer value;
    private final String type;

    public BuyPropertyResponse(String address, Integer value, String type) {
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
