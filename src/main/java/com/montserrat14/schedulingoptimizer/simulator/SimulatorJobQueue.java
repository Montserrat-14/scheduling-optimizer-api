package com.montserrat14.schedulingoptimizer.simulator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SimulatorJobQueue {

    class JobComparator implements Comparator<SimulatorJob> {
        public int compare(SimulatorJob sj1, SimulatorJob sj2) {
            if (sj1 == null || sj2 == null){
                throw new IllegalArgumentException("One of the Simulator job is null");
            }

            return sj1.getCurrentTask().getAlgorithmPriority() > sj2.getCurrentTask().getAlgorithmPriority()  ? 1 : -1;
        }
    }

    private int totalCapacity;
    private JobComparator comparator;
    private PriorityQueue<SimulatorJob> priorityQueue;

    public SimulatorJobQueue(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.comparator = new JobComparator();
        this.priorityQueue = new PriorityQueue<>(this.totalCapacity,this.comparator);
    }

    public void addJob(SimulatorJob newSimulatorJob){
        this.priorityQueue.add(newSimulatorJob);
    }

    public SimulatorJob getNextSimulatorJob(){

        if(this.priorityQueue.isEmpty()){
           return null;
        }

        return this.priorityQueue.remove();
    }

    public int getSize(){
        return this.priorityQueue.size();
    }

    public void clearAll(){
        this.priorityQueue.clear();
    }

}
