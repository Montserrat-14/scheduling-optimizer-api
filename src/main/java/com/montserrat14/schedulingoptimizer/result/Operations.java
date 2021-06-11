package com.montserrat14.schedulingoptimizer.result;

public class Operations {

    private String id;
    private String job;
    private int startTime;
    private int endTime;

    public Operations() {

    }

    public Operations(String id, String job, int startTime, int endTime) {
        this.id = id;
        this.job = job;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
