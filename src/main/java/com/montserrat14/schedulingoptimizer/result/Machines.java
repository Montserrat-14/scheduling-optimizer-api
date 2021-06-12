package com.montserrat14.schedulingoptimizer.result;

import java.util.ArrayList;
import java.util.List;

public class Machines {

    private String name;
    private List<Operations> listOperations;

    public Machines() {
        this.name = "";
        this.listOperations = new ArrayList<>();
    }

    public Machines(String name) {
        this.name = name;
        this.listOperations = new ArrayList<>();
    }

    public Machines(String name, List<Operations> listOperations) {
        this.name = name;
        this.listOperations = listOperations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operations> getOperations() {
        return listOperations;
    }

    public void setOperations(List<Operations> listOperations) {
        listOperations = listOperations;
    }

    public void addOperation(Operations operation){
        this.listOperations.add(operation);

    }
}
