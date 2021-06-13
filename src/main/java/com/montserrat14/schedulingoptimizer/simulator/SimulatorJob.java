package com.montserrat14.schedulingoptimizer.simulator;

import com.montserrat14.schedulingoptimizer.models.order.Job;
import com.montserrat14.schedulingoptimizer.models.order.Operation;
import java.util.ArrayList;
import java.util.List;

public class SimulatorJob {

    private List<Task> taskList;
    private int numberOfTasks;
    private int startTime;
    private int endTime;
    private int currentTaskIndex;
    private int currentMachineIndex;
    private String name;
    private String parentName;

    public SimulatorJob(int operationID, List<Operation> operationList, Job job) {
        init(operationList, operationID, job);
    }

    private void init(List<Operation> operationList, int operationID,Job job){
        this.name = job.getName();
        this.parentName = parentName;
        this.taskList = new ArrayList<>();
        this.currentTaskIndex = 0;

        int countID = operationID;
        for(Operation operation : operationList){
                this.taskList.add(new Task(this,
                        operation.getIndex(),
                        operation.getResourceId(),
                        operation.getEstimatedTime(),
                        countID++));
        }

        this.numberOfTasks = this.taskList.size();
    }


    public List<Task> getTaskList() {
        return taskList;
    }

    public int getNumberOfTasks() {
        return this.numberOfTasks;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getCurrentTaskIndex() {
        return currentTaskIndex;
    }

    public Task getCurrentTask(){
        return this.getTaskList().get(this.currentTaskIndex);
    }

    public int getCurrentMachineIndex() {
        return currentMachineIndex;
    }

    public void setCurrentMachineIndex(int currentMachineIndex) {
        this.currentMachineIndex = currentMachineIndex;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setCurrentTaskIndex(int currentTaskIndex) {
        this.currentTaskIndex = currentTaskIndex;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }
}
