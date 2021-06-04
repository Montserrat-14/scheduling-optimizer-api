package com.montserrat14.schedulingoptimizer.simulator;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.order.Job;
import com.montserrat14.schedulingoptimizer.models.resource.Resources;
import org.uma.jmetal.solution.integersolution.IntegerSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulator {

    private List<Station> stationList;
    private List<SimulatorJob> simulatorJobList;
    private SchedulingSystem problemInfo;
    private List<Integer> sortedSolutionList;

    private Map<Integer,Task> allTasks;

    private EventQueue eventQueue;

    public Simulator(SchedulingSystem problemInfo) {
        this.problemInfo = problemInfo;
        init();
    }

    public void run(IntegerSolution solution){
        // IntegerSolution ex: [3,0,6,4,1,2,5]
        this.sortedSolutionList = new ArrayList<>();

        for (int i = 0; i < solution.getNumberOfVariables(); i++) {
            this.sortedSolutionList.add(solution.getVariable(i));
            this.allTasks.get(this.sortedSolutionList.get(i)).setAlgorithmPriority(i);
        }

    }

    public void launchStartEvent(int time, SimulatorJob simulatorJob, Task task){


    }

    public void launchEndEvent(int time, SimulatorJob simulatorJob, Task task){

        time += task.getDuration();
        eventQueue.addEvent(new Event(simulatorJob, task, EventType.END, time));

    }

    /**
     * SET's and GET's
     */

    private void init(){

        this.stationList = new ArrayList<>();
        this.simulatorJobList =  new ArrayList<>();
        this.allTasks = new HashMap<>();

        //init simulator Stations
        for (Resources station : this.problemInfo.getResource().getResources()) {
            this.stationList.add(new Station(station.getId(),station.getQuantity(),this.problemInfo.getOrder().getJobs().size()));
        }

        //init simulatorJobs
        List<Task> allTaskTemp = new ArrayList<>();

        int operationCount = 0;

        for(Job job : this.problemInfo.getOrder().getJobs()){
            SimulatorJob simulatorJob = new SimulatorJob(operationCount, job.getOperations());
            this.simulatorJobList.add(simulatorJob);
            operationCount += job.getNumberOfOperations();

            allTaskTemp.addAll(simulatorJob.getTaskList());
        }

        //init map with all tasks
        for (Task task : allTaskTemp) {
            this.allTasks.put(task.getId(),task);
        }

        this.eventQueue = new EventQueue(this.allTasks.size()*2);

    }

    public List<Station> getStationList() {
        return stationList;
    }

    public List<SimulatorJob> getSimulatorJobList() {
        return simulatorJobList;
    }

    public SchedulingSystem getProblemInfo() {
        return problemInfo;
    }

    public List<Integer> getSortedSolutionList() {
        return sortedSolutionList;
    }

    public Map<Integer, Task> getAllTasks() {
        return allTasks;
    }
}
