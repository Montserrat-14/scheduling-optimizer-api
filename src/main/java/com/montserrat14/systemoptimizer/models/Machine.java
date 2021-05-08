package com.montserrat14.systemoptimizer.models;

public class Machine extends Resource {

    private String type;
    private int quantity;
    private double cost;

    public Machine(String type, int quantity, double cost) {
        this.type = type;
        this.quantity = quantity;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

}
