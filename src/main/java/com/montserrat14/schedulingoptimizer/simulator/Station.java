package com.montserrat14.schedulingoptimizer.simulator;

import com.montserrat14.schedulingoptimizer.exception.SimulatorException;
import com.montserrat14.schedulingoptimizer.models.order.Job;

import java.util.List;

public class Station {

    private int id;
    private List<Machine> machineList;
    private SimulatorJobQueue simulatorJobQueue;

    public Station(int id, int totalMachine, int totalJobs) {
        this.id = id;
        init(totalMachine, totalJobs);
    }

    private void init(int totalMachine, int totalJobs){
        for (int i = 0; i < totalMachine ; i++) {
            this.machineList.add(new Machine(this));
        }

        this.simulatorJobQueue = new SimulatorJobQueue(totalJobs);
    }

    public int getId() {
        return id;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public boolean addJob(SimulatorJob simulatorJob){

        boolean machineAvailable = false;

        for (int i = 0; i < machineList.size(); i++) {
            if(machineList.get(i).isAvailable()){
                machineList.get(i).addJob(simulatorJob);
                simulatorJob.setCurrentMachineIndex(i);
                machineAvailable = true;
            }
        }

        if(!machineAvailable){
            this.simulatorJobQueue.addJob(simulatorJob);
        }

        return machineAvailable;
    }

    public SimulatorJob removeJob(SimulatorJob simulatorJob){

       Machine machine = machineList.get(simulatorJob.getCurrentMachineIndex());
       machine.removeJob();

       SimulatorJob nextJob = this.simulatorJobQueue.getNextSimulatorJob();

       if(nextJob == null){
           return null;
       }

       machine.addJob(nextJob);
       nextJob.setCurrentMachineIndex(simulatorJob.getCurrentMachineIndex());

       return nextJob;

    }
}
