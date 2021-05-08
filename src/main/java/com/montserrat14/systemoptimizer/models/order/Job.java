package com.montserrat14.systemoptimizer.models.order;

import java.util.List;

public class Job {

    private String name;
    private String description;
    private List<Operation> operations;

    public Job() {
    }

    public Job(String name, String description, List<Operation> operations) {
        this.name = name;
        this.description = description;
        this.operations = operations;
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
