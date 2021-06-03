package com.montserrat14.schedulingoptimizer.models.order;

public class Objectives {
    private boolean totalTime;
    private boolean cost;

    public Objectives() {
    }

    public Objectives(boolean totalTime, boolean cost) {
        this.totalTime = totalTime;
        this.cost = cost;
    }

    public boolean isTotalTime() {
        return totalTime;
    }

    public void setTotalTime(boolean totalTime) {
        this.totalTime = totalTime;
    }

    public boolean isCost() {
        return cost;
    }

    public void setCost(boolean cost) {
        this.cost = cost;
    }
}
