package com.montserrat14.schedulingoptimizer.simulator;

public class Task {

    private SimulatorJob parentJob;
    private int stationID;
    private int duration;
    private int precedenceIndex;
    private int id;
    private int algorithmPriority;

    public Task(SimulatorJob parentJob, int precedenceIndex, int stationID, int duration, int id) {
        this.parentJob = parentJob;
        this.precedenceIndex = precedenceIndex;
        this.stationID = stationID;
        this.duration = duration;
        this.id = id;
    }

    public SimulatorJob getParentJob() {
        return parentJob;
    }

    public int getStationID() {
        return stationID;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrecedenceIndex() {
        return precedenceIndex;
    }

    public int getId() {
        return id;
    }

    public int getAlgorithmPriority() {
        return algorithmPriority;
    }

    public void setAlgorithmPriority(int algorithmPriority) {
        this.algorithmPriority = algorithmPriority;
    }
}
