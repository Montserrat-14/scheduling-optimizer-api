package com.montserrat14.schedulingoptimizer.result;

import java.util.List;

public class Solutions {

    private List<Objectives> Objectives;
    private List<Stations> Stations;

    public Solutions() {

    }

    public Solutions(List<Objectives> objectives, List<Stations> stations) {
        Objectives = objectives;
        Stations = stations;
    }

    public List<Objectives> getObjectives() {
        return Objectives;
    }

    public void setObjectives(List<Objectives> objectives) {
        Objectives = objectives;
    }

    public List<Stations> getStations() {
        return Stations;
    }

    public void setStations(List<Stations> stations) {
        Stations = stations;
    }
}
