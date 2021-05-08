package com.montserrat14.systemoptimizer.models;

import java.util.Date;
import java.util.List;

public class Job {

    private String name;
    private List<Task> listTasks;
    private Date dueDate;
    private Double weight;

    public Job(String name, List<Task> listTasks, Date dueDate, Double weight) {
        this.name = name;
        this.listTasks = listTasks;
        this.dueDate = dueDate;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getListTasks() {
        return listTasks;
    }

    public void setListTasks(List<Task> listTasks) {
        this.listTasks = listTasks;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
