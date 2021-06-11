package com.montserrat14.schedulingoptimizer.result;

import java.util.List;

public class Stations {

    public List<Machines> Machines;

    public Stations() {
    }

    public Stations(List<Machines> Machines) {
        this.Machines = Machines;
    }

    public List<Machines> getMachines() {
        return Machines;
    }

    public void setMachines(List<Machines> Machines) {
        this.Machines = Machines;
    }
}
