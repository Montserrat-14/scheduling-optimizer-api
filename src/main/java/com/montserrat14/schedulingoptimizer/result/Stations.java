package com.montserrat14.schedulingoptimizer.result;

import java.util.ArrayList;
import java.util.List;

public class Stations {

    private int id;
    private List<Machines> listMachines;

    public Stations(int id) {
        this.id = id;
        this.listMachines = new ArrayList<>();
    }

    public Stations(List<Machines> listMachines) {
        this.listMachines = listMachines;
    }

    public List<Machines> getMachines() {
        return listMachines;
    }

    public void setMachines(List<Machines> listMachines) {
        this.listMachines = listMachines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addMachine(Machines machine){
        this.listMachines.add(machine);
    }
}
