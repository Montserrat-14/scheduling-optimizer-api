package com.montserrat14.schedulingoptimizer.models.order;

import java.util.List;

public class Order {

    public String name;
    public String description;
    public List<Job> jobs;
    public Objectives objectives;
    public String duration;

    public Order() {

    }

    public Order(String name, String description, List<Job> jobs, Objectives objectives, String duration) {
        this.name = name;
        this.description = description;
        this.jobs = jobs;
        this.objectives = objectives;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Objectives getObjectives() {
        return objectives;
    }

    public void setObjectives(Objectives objectives) {
        this.objectives = objectives;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getTotalNumberOfOperations() {
       return this.jobs.stream()
                .map(job -> job.getNumberOfOperations())
                .reduce(0, Integer::sum);
    }
}
