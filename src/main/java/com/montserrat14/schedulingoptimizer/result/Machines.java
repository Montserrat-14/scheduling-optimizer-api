package com.montserrat14.schedulingoptimizer.result;

import java.util.ArrayList;
import java.util.List;

public class Machines {

    public String name;
    public List<Operations> Operations;

    public Machines() {
        this.name = "";
        this.Operations = new ArrayList<>();
    }

    public Machines(String name) {
        this.name = name;
        this.Operations = new ArrayList<>();
    }

    public Machines(String name, List<Operations> Operations) {
        this.name = name;
        this.Operations = Operations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operations> getOperations() {
        return Operations;
    }

    public void setOperations(List<Operations> operations) {
        Operations = operations;
    }
}
