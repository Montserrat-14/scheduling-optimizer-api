package com.montserrat14.schedulingoptimizer.result;

public class Objectives {

    public String name;
    public int value;

    public Objectives() {
    }

    public Objectives(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
