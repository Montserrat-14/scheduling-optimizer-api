package com.montserrat14.schedulingoptimizer.simulator;

public class Event {

    private SimulatorJob simulatorJob;
    private Task task;
    private EventType type;
    private int time;
    private String resourceName;

    public Event(SimulatorJob simulatorJob, Task task, EventType type, int time, String resourceName) {
        this.simulatorJob = simulatorJob;
        this.resourceName = resourceName;
        this.task = task;
        this.type = type;
        this.time = time;
    }

    public SimulatorJob getSimulatorJob() {
        return simulatorJob;
    }

    public Task getTask() {
        return task;
    }

    public EventType getType() {
        return type;
    }

    public int getTime() {
        return time;
    }

    public void setSimulatorJob(SimulatorJob simulatorJob) {
        this.simulatorJob = simulatorJob;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStartTime(){
        return this.time - task.getDuration();
    }

    public String getResourceName() {
        return resourceName;
    }
}
