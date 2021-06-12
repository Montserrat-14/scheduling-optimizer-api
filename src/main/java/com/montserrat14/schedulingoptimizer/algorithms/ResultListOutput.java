package com.montserrat14.schedulingoptimizer.algorithms;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.problem.factory.ISchedulingProblem;
import com.montserrat14.schedulingoptimizer.result.*;
import com.montserrat14.schedulingoptimizer.simulator.*;
import org.json.JSONObject;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.solution.permutationsolution.impl.IntegerPermutationSolution;
import org.uma.jmetal.util.fileoutput.SolutionListOutput;

import java.util.*;

public class ResultListOutput extends SolutionListOutput {
    private ISchedulingProblem problem;
    private List<? extends Solution<?>> solutionList;
    private Simulator simulator;

    private List<Stations> listStations;
    private List<JSONObject> results;


    public ResultListOutput(Algorithm<List<? extends Solution<?>>> algorithm, ISchedulingProblem problem, SchedulingSystem problemS) {
        super(algorithm.getResult());
        this.solutionList = algorithm.getResult();
        this.problem = problem;
        this.listStations = new ArrayList<>();
        this.results = new ArrayList<>();

        initSimulator(problemS);

    }

    private void initSimulator(SchedulingSystem schedulingSystem) {

        for (Solution<?> intPermutationSolution : this.solutionList) {
            this.simulator = new Simulator(schedulingSystem);
            this.simulator.run((IntegerPermutationSolution) intPermutationSolution);

            Objectives resultObjective = new Objectives("makespan", this.simulator.getObjective());
            List<Objectives> listObjectives = new ArrayList<>();
            listObjectives.add(resultObjective);

            results.add(new JSONObject(new Solutions(listObjectives, getResultMachinesPerSolutionList())));
        }

        System.out.println();
    }

    private void initListStations(){
        this.listStations = new ArrayList<>();
        for(Station station : this.simulator.getStationList()){
            Stations currentStation =  new Stations(station.getId());
            for (Machine machine : station.getMachineList()){
                Machines resultMachine = new Machines(station.getName());
                currentStation.addMachine(resultMachine);
            }
            this.listStations.add(currentStation);
        }
    }

    private List<Stations> getResultMachinesPerSolutionList() {

        initListStations();

        for (Event pastEvent : this.simulator.getEventQueue().getPastEventsList()) {

                Operations resultOperation = new Operations();

                resultOperation.setId(pastEvent.getTask().getId());
                resultOperation.setJob(pastEvent.getSimulatorJob().getName());
                resultOperation.setEndTime(pastEvent.getTime());
                resultOperation.setStartTime(pastEvent.getStartTime());

                Stations stationToAdd = this.listStations.get(pastEvent.getTask().getStationID());
                Machines machineToAdd = stationToAdd.getMachines().get(pastEvent.getTask().getMachineID());
                machineToAdd.addOperation(resultOperation);

        }

        return this.listStations;
    }

    public List<JSONObject> getResults() {
        return results;
    }

    public void setResults(List<JSONObject> results) {
        this.results = results;
    }
}