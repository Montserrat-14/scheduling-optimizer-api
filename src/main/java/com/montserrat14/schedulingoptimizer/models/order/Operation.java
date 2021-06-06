package com.montserrat14.schedulingoptimizer.models.order;

public class Operation {

    private int resourceId;
    private int estimatedTime;
    private int index;

    public Operation() {
    }

    public Operation(int resourceId, int estimatedTime, int index) {
        this.resourceId = resourceId;
        this.estimatedTime = estimatedTime;
        this.index = index;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
