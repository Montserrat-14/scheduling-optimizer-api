package com.montserrat14.schedulingoptimizer.algorithms;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.problem.factory.ISchedulingProblem;
import com.montserrat14.schedulingoptimizer.result.*;
import com.montserrat14.schedulingoptimizer.simulator.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.solution.permutationsolution.impl.IntegerPermutationSolution;
import org.uma.jmetal.util.fileoutput.SolutionListOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultListOutput extends SolutionListOutput {
    private ISchedulingProblem problem;
    private List<? extends Solution<?>> solutionList;
    private Simulator simulator;

    private List<Machines> resultMachinesPerSolutionList;
    private List<Stations> resulStationPerSolution;
    private List<JSONObject> results;


    public ResultListOutput(Algorithm<List<? extends Solution<?>>> algorithm, ISchedulingProblem problem, SchedulingSystem problemS) {
        super(algorithm.getResult());
        this.solutionList = algorithm.getResult();
        this.problem = problem;
        this.resultMachinesPerSolutionList = new ArrayList<>();
        this.resulStationPerSolution = new ArrayList<>();
        this.results = new ArrayList<>();

        initSimulator(problemS);

    }

    private void initSimulator(SchedulingSystem schedulingSystem) {

        for (Solution<?> intPermutationSolution : this.solutionList) {
            this.simulator = new Simulator(schedulingSystem);
            this.simulator.run((IntegerPermutationSolution) intPermutationSolution);

            Objectives resultObjective = new Objectives("markspan", this.simulator.getObjective());

            //results.add(new JSONArray().put(new JSONObject(new Solutions(resultObjective,getResultMachinesPerSolutionList()))));
            results.add(new JSONObject(new Solutions(resultObjective, getResultMachinesPerSolutionList())));
        }

        System.out.println();
    }

    private List<Stations> getResultMachinesPerSolutionList() {

        for (List<Event> events : this.simulator.getEventQueue().getPastEventsByMachine().values()) {

            for (Event pastEvent : events) {

                Machines resultMachine = new Machines();
                Operations resultOperation = new Operations();

                resultMachine.setName(pastEvent.getResourceName());

                resultOperation.setId(String.valueOf(pastEvent.getSimulatorJob().getCurrentMachineIndex()));
                resultOperation.setJob(pastEvent.getSimulatorJob().getName());
                resultOperation.setEndTime(pastEvent.getTime());
                resultOperation.setStartTime(pastEvent.getStartTime());

                resultMachine.getOperations().add(resultOperation);

                resultMachinesPerSolutionList.add(resultMachine);

                resulStationPerSolution.add(new Stations(resultMachinesPerSolutionList));
            }
        }

        return resulStationPerSolution;
    }

    public List<JSONObject> getResults() {
        return results;
    }

    public void setResults(List<JSONObject> results) {
        this.results = results;
    }
}