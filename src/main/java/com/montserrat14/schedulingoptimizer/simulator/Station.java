package com.montserrat14.schedulingoptimizer.simulator;

import com.montserrat14.schedulingoptimizer.exception.SimulatorException;
import com.montserrat14.schedulingoptimizer.models.order.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {

    private int id;
    private List<Machine> machineList;
    private SimulatorJobQueue simulatorJobQueue;
    private List<Integer> tasksToRunList;

    public Station(int id, int totalMachine, int totalJobs, List<Integer> tasksToRunList) {
        init(id, totalMachine, totalJobs, tasksToRunList);
    }

    private void init(int id, int totalMachine, int totalJobs, List<Integer> tasksToRunList ){
        this.id = id;
        this.machineList = new ArrayList<>();
        this.tasksToRunList = tasksToRunList;

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
                addJobToMachine(simulatorJob,i);
                machineAvailable = true;
                break;
            }
        }

        if(!machineAvailable){
            this.simulatorJobQueue.addJob(simulatorJob);
        }

        return machineAvailable;
    }

    private boolean addJobToMachine(SimulatorJob simulatorJob, int machineIndex){
        
        if(Collections.min(this.tasksToRunList) != simulatorJob.getCurrentTask().getAlgorithmPriority()){
            return false;
        }

        machineList.get(machineIndex).addJob(simulatorJob);
        simulatorJob.setCurrentMachineIndex(machineIndex);

        this.tasksToRunList.remove((Integer) simulatorJob.getCurrentTask().getAlgorithmPriority());

        return  true;

    }

    public SimulatorJob removeJob(SimulatorJob simulatorJob){

       Machine machine = machineList.get(simulatorJob.getCurrentMachineIndex());
       machine.removeJob();

       SimulatorJob nextJob = this.simulatorJobQueue.getNextSimulatorJob();

        if(nextJob == null){
            return null;
        }

       if (addJobToMachine(nextJob,simulatorJob.getCurrentMachineIndex())){
           return nextJob;
       }

       this.simulatorJobQueue.addJob(nextJob);

       return null;

    }
}
