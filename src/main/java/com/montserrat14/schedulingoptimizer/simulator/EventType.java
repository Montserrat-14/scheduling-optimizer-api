package com.montserrat14.schedulingoptimizer.simulator;

public enum EventType {

    START("Start"),
    END("End");

    private String type;

    EventType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }
}
