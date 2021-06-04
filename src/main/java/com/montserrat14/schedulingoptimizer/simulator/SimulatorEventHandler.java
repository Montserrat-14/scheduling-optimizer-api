package com.montserrat14.schedulingoptimizer.simulator;

public class SimulatorEventHandler {

    private Simulator simulator;

    public SimulatorEventHandler(Simulator simulator) {
        this.simulator = simulator;
    }

    public void startEvent(Event event){

        SimulatorJob simulatorJob =  event.getSimulatorJob();
        Task task = event.getTask();

        if(simulatorJob.getCurrentTaskIndex() != task.getPrecedenceIndex()){
            //TODO: "Precendence missmatch" - Tratar das constraints
        }

        //

        Station station = simulator.getStationList().get(task.getStationID());

        if(station.addJob(simulatorJob)){

        }

    }

    public void endEvent(Event event){

        SimulatorJob simulatorJob =  event.getSimulatorJob();
        Task task = event.getTask();

        Station station = simulator.getStationList().get(task.getStationID());
        SimulatorJob nextJob = station.removeJob(simulatorJob);

        //TODO: Handle next Job

        int currentTask =  simulatorJob.getCurrentTaskIndex() + 1;
        simulatorJob.setCurrentTaskIndex(currentTask);

        if(currentTask == simulatorJob.getNumberOfTasks()){
            //Job Ended
            simulatorJob.setEndTime(event.getTime());
        }else{
            //TODO: simulator.launchStartEvent();
        }
    }
}
