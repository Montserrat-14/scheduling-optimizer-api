package com.montserrat14.systemoptimizer.models;

public class Employee extends Resource {

    private String type;
    private int quantity;
    private double salary;

    public Employee(String type, int quantity, double salary) {
        this.type = type;
        this.quantity = quantity;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
