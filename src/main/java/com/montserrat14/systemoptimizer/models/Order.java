package com.montserrat14.systemoptimizer.models;

import java.util.List;

public class Order {

    private List<Job> listJobs;

    public Order(List<Job> listJobs) {
        this.listJobs = listJobs;
    }

    public List<Job> getListJobs() {
        return listJobs;
    }

    public void setListJobs(List<Job> listJobs) {
        this.listJobs = listJobs;
    }
}
