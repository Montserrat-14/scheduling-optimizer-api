package com.montserrat14.schedulingoptimizer.simulator;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.order.Job;
import com.montserrat14.schedulingoptimizer.models.resource.Resources;
import org.uma.jmetal.solution.permutationsolution.PermutationSolution;

import java.util.*;

public class Simulator {

    private List<Station> stationList;
    private List<SimulatorJob> simulatorJobList;
    private List<Integer> sortedSolutionList;

    private Map<Integer,Task> allTasks;
    private Map<Integer,List<Integer>> allTaskByMachine;

    private SchedulingSystem problemInfo;
    private EventQueue eventQueue;

    private int maxCompletionTime = 0;

    private int objective;
    private int numberOfViolatedConstrains;

    public Simulator(SchedulingSystem problemInfo) {
        this.problemInfo = problemInfo;
        init();
    }

    public void run(PermutationSolution<Integer> solution){
        // IntegerSolution ex: [3,0,6,4,1,2,5]
        this.sortedSolutionList = new ArrayList<>();
        System.out.println("\n\n\n############################################################################## NEW SOLUTION");
        for (int i = 0; i < solution.getNumberOfVariables(); i++) {
            System.out.print("Index: " + i + " Task: " + solution.getVariable(i) + "\n");
            this.sortedSolutionList.add(solution.getVariable(i));
            this.allTasks.get(this.sortedSolutionList.get(i)).setAlgorithmPriority(i);
        }
        System.out.println("");

        // add tasks by Machine
        for (Task task : this.allTasks.values()) {
            maxCompletionTime += task.getDuration();
            if(this.allTaskByMachine.containsKey(task.getStationID())){
                this.allTaskByMachine.get(task.getStationID()).add(task.getAlgorithmPriority());
            }else{
                this.allTaskByMachine.put(task.getStationID(),new ArrayList<>(Arrays.asList(task.getAlgorithmPriority())));
            }
        }
        maxCompletionTime *= 3;
        //init simulator Stations
        for (Resources station : this.problemInfo.getResource().getResources()) {
            List<Integer> precedenceList = this.allTaskByMachine.get(station.getId());
            this.stationList.add(new Station(station.getId(),station.getName(),station.getQuantity(),this.problemInfo.getOrder().getJobs().size(), precedenceList));
        }

        SimulatorEventHandler simulatorEventHandler =  new SimulatorEventHandler(this);

        for(SimulatorJob job : simulatorJobList){
            launchStartEvent(0,job,job.getCurrentTask());
        }

        while (!hasEnded()){
            Event ev = this.eventQueue.getNextEvent();
            if(ev == null){
                this.numberOfViolatedConstrains += 1;
                this.objective = maxCompletionTime;
                break;
            }
            System.out.println("Event time: " + ev.getTime() + "\n" +
                               "Event Type: " + ev.getType() + "\n" +
                               "Job name: " + ev.getSimulatorJob().getName() + "\n" +
                               "Task: " + ev.getTask().getId() + "\n" +
                               "Start Time - for End Event: " + ev.getStartTime());
            System.out.println("\n");
            System.out.println("############################################################");
            System.out.println("\n");
            simulatorEventHandler.catchEvent(ev);
        }


        if(this.objective != maxCompletionTime) this.objective = getMakespan();
        System.out.println("Makespan: " + this.objective);


    }

    private int getMakespan(){
        return simulatorJobList.stream()
                .max(Comparator.comparing(SimulatorJob::getEndTime)).get().getEndTime();
    }

    private boolean hasEnded(){
        return simulatorJobList.stream().allMatch(job -> job.getEndTime() > 0);
    }

    public void launchStartEvent(int time, SimulatorJob simulatorJob, Task task){

        eventQueue.addEvent(new Event(simulatorJob, task, EventType.START, time));

    }

    public void launchEndEvent(int time, SimulatorJob simulatorJob, Task task){

        time += task.getDuration();
        eventQueue.addEvent(new Event(simulatorJob, task, EventType.END, time));

    }

    private void init(){

        this.stationList = new ArrayList<>();
        this.simulatorJobList =  new ArrayList<>();
        this.allTasks = new HashMap<>();
        this.allTaskByMachine = new HashMap<>();

        //init simulatorJobs
        List<Task> allTaskTemp = new ArrayList<>();

        int operationCount = 0;

        for(Job job : this.problemInfo.getOrder().getJobs()){
            SimulatorJob simulatorJob = new SimulatorJob(operationCount, job.getOperations(), job);
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

    /**
     * SET's and GET's
     */

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

    public int getObjective() {
        return objective;
    }

    public void setObjective(int objective) {
        this.objective = objective;
    }


    public int getNumberOfViolatedConstraints(){ return numberOfViolatedConstrains; }

    public EventQueue getEventQueue() {
        return eventQueue;
    }

    public Map<Integer, List<Integer>> getAllTaskByMachine() {
        return allTaskByMachine;
    }
}
