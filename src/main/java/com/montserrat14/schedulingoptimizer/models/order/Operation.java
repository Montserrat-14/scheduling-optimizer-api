package com.montserrat14.schedulingoptimizer.models.order;

public class Operation {

    private String resourceId;
    private String estimatedTime;
    private String index;

    public Operation() {
    }

    public Operation(String resourceId, String estimatedTime, String index) {
        this.resourceId = resourceId;
        this.estimatedTime = estimatedTime;
        this.index = index;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
