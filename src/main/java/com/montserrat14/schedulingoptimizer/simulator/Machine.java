package com.montserrat14.schedulingoptimizer.simulator;

import com.montserrat14.schedulingoptimizer.models.order.Job;

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
