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
    private HashMap<String, List<Event>> pastEventsByMachine;

    public EventQueue(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.comparator = new EventComparator();
        this.priorityQueue = new PriorityQueue<>(this.totalCapacity,this.comparator);
        this.pastEventsList = new ArrayList<>();
        this.pastEventsByMachine = new LinkedHashMap<>();
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

            //this is for request result
            if(existMachine(event.getResourceName())){
                List<Event> existedList = getListEventFromMapPerMachine(event.getResourceName());
                existedList.add(event);
                this.pastEventsByMachine.put(event.getResourceName(),existedList);
            }else{//new Machine add
                List<Event> newList = getListEventFromMapPerMachine(event.getResourceName());
                newList.add(event);
                this.pastEventsByMachine.put(event.getResourceName(),newList);
            }
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

    public HashMap<String, List<Event>> getPastEventsByMachine() {
        return pastEventsByMachine;
    }

    public void setPastEventsByMachine(HashMap<String, List<Event>> pastEventsByMachine) {
        this.pastEventsByMachine = pastEventsByMachine;
    }

    private boolean existMachine(String name){

        return pastEventsByMachine.containsValue(name);
    }

    private List<Event> getListEventFromMapPerMachine(String name){

        if(this.pastEventsByMachine.isEmpty()){
            return new ArrayList<>();
        }

        if(this.pastEventsByMachine.containsValue(name)){
            return this.pastEventsByMachine.get(name);
        }
        return new ArrayList<>();
    }
}
