package com.buildingBlocks.trajectory.application.buyProperty;

public class BuyPropertyResponse {
    private final String address;
    private final Integer value;
    private final String type;
    private final String message;

    public BuyPropertyResponse(String address, Integer value, String type , String message) {
        this.address = address;
        this.value = value;
        this.type = type;
        this.message = message;
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

    public String getMessage() {
        return message;
    }
}
