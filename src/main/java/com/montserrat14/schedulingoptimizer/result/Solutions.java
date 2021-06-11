package com.montserrat14.schedulingoptimizer.result;

import java.util.List;

public class Solutions {

    public Objectives Objectives;
    public List<Stations> Stations;

    public Solutions() {

    }

    public Solutions(Objectives objectives, List<Stations> Stations) {
        this.Objectives = objectives;
        this.Stations = Stations;
    }

    public List<Stations> getStations() {
        return Stations;
    }

    public void setStations(List<Stations> Stations) {
        this.Stations = Stations;
    }

    public void setObjectives(Objectives objectives) {
        Objectives = objectives;
    }

    public Objectives getObjectives() {
        return Objectives;
    }
}
