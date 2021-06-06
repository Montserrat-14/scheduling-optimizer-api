package com.montserrat14.schedulingoptimizer.simulator;


public class Machine {

    private SimulatorJob actualJob = null;
    private Station parentStation;

    public Machine(Station parentStation) {
        this.parentStation = parentStation;
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

}
