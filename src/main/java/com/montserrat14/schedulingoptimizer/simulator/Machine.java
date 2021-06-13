package com.montserrat14.schedulingoptimizer.simulator;


public class Machine {

    private SimulatorJob actualJob = null;
    private Station parentStation;
    private int id;

    public Machine(Station parentStation, int id) {

        this.parentStation = parentStation;
        this.id = id;
    }

    public void addJob(SimulatorJob newJob){
        this.actualJob = newJob;
    }

    public void removeJob(){
        this.actualJob = null;
    }

    public boolean isAvailable(){
        return actualJob == null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
