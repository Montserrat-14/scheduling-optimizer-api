package com.montserrat14.schedulingoptimizer.simulator;

public class SimulatorEventHandler {

    private final Simulator simulator;

    public SimulatorEventHandler(Simulator simulator) {
        this.simulator = simulator;
    }

    private void startEvent(Event event){

        SimulatorJob simulatorJob =  event.getSimulatorJob();
        Task task = event.getTask();

        if(simulatorJob.getCurrentTaskIndex() != task.getPrecedenceIndex()){
            //TODO: "Precendence missmatch" - Tratar das constraints
        }

        Station station = this.simulator.getStationList().get(task.getStationID());

        if(station.addJob(simulatorJob)){
            this.simulator.launchEndEvent(event.getTime(),simulatorJob,task);
        }

    }

    private void endEvent(Event event){

        SimulatorJob simulatorJob =  event.getSimulatorJob();
        Task task = event.getTask();

        Station station = this.simulator.getStationList().get(task.getStationID());
        SimulatorJob nextJob = station.removeJob(simulatorJob);

        //the station has job in waiting queue
        if(nextJob != null){
            Task nextJobTask = nextJob.getCurrentTask();
            this.simulator.launchEndEvent(event.getTime(),nextJob,nextJobTask);
        }

        int currentTaskIndex =  simulatorJob.getCurrentTaskIndex() + 1;
        simulatorJob.setCurrentTaskIndex(currentTaskIndex);

        if(currentTaskIndex == simulatorJob.getNumberOfTasks()){
            //Job Ended
            simulatorJob.setEndTime(event.getTime());
        }else{
            this.simulator.launchStartEvent(event.getTime(),simulatorJob,simulatorJob.getCurrentTask());
        }
    }

    public void catchEvent(Event event){

        switch (event.getType()){

            case START:
                startEvent(event);
                break;
            case END:
                endEvent(event);
                break;
        }
    }

}
