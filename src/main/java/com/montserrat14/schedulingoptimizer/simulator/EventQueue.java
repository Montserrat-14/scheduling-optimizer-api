package com.montserrat14.schedulingoptimizer.simulator;

import java.util.*;

public class EventQueue {

    class EventComparator implements Comparator<Event> {
        public int compare(Event ev1, Event ev2) {
            if (ev1 == null || ev2 == null){
                throw new IllegalArgumentException("One of the events is null");
            }

            double dif = ev1.getTime() - ev2.getTime();

            int timeOrder =  dif > 0 ? 1 : (dif < 0) ? -1 : 0;

            if(timeOrder != 0){
                return timeOrder;
            }

            return ev1.getTask().getAlgorithmPriority() > ev2.getTask().getAlgorithmPriority()  ? 1 : -1;
        }
    }

    private int totalCapacity;
    private EventComparator comparator;
    private PriorityQueue<Event> priorityQueue;
    private List<Event> pastEventsList;

    public EventQueue(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.comparator = new EventComparator();
        this.priorityQueue = new PriorityQueue<>(this.totalCapacity,this.comparator);
        this.pastEventsList = new ArrayList<>();
    }

    public void addEvent(Event newEvent){
        this.priorityQueue.add(newEvent);
    }

    public Event getNextEvent(){

        if(this.priorityQueue.isEmpty()){
           return null;
        }

        Event event = this.priorityQueue.remove();

        if(event.getType().equals(EventType.END)){
            this.pastEventsList.add(event);
        }

        return event;
    }

    public int getSize(){
        return this.priorityQueue.size();
    }

    public void clearAll(){
        this.priorityQueue.clear();
    }

    public List<Event> getPastEventsList() {
        return pastEventsList;
    }

}
