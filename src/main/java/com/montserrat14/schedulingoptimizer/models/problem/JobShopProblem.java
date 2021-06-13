package com.montserrat14.schedulingoptimizer.models.problem;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.problem.factory.ISchedulingProblem;
import com.montserrat14.schedulingoptimizer.simulator.Simulator;
import org.uma.jmetal.problem.permutationproblem.impl.AbstractIntegerPermutationProblem;
import org.uma.jmetal.solution.permutationsolution.PermutationSolution;
import org.uma.jmetal.util.solutionattribute.impl.NumberOfViolatedConstraints;
import org.uma.jmetal.util.solutionattribute.impl.OverallConstraintViolation;

public class JobShopProblem extends AbstractIntegerPermutationProblem implements ISchedulingProblem {

    private SchedulingSystem problemRequest;
    private int length;
    public OverallConstraintViolation<PermutationSolution<Integer>> overallConstraintViolationDegree;
    public NumberOfViolatedConstraints<PermutationSolution<Integer>> numberOfViolatedConstraints;
    private Simulator simulator;

    @Override
    public void createProblem(SchedulingSystem problemRequest) {

        this.problemRequest = problemRequest;

        setName("Job Shop Problem");

        this.length = problemRequest.getOrder().getTotalNumberOfOperations();
        setNumberOfVariables(this.length);
        setNumberOfObjectives(problemRequest.getOrder().objectives.getNumOfObjectives());
        overallConstraintViolationDegree = new OverallConstraintViolation<>();
        numberOfViolatedConstraints = new NumberOfViolatedConstraints<>();

    }

    @Override
    public void evaluate(PermutationSolution<Integer> solution) {
        this.simulator = new Simulator(this.problemRequest);
        this.simulator.run(solution);
        solution.setObjective(0, this.simulator.getObjective());
        evaluateConstraints(solution, this.simulator);
    }

    private void evaluateConstraints(PermutationSolution<Integer> solution, Simulator simulator) {
        int violated = simulator.getNumberOfViolatedConstraints();
        numberOfViolatedConstraints.setAttribute(solution, violated);
        overallConstraintViolationDegree.setAttribute(solution, (double) violated);
    }

    public SchedulingSystem getProblem() {
        return this.problemRequest;
    }

    @Override
    public Simulator getSimulator() {
        return this.simulator;
    }

    @Override
    public int getLength() {
        return this.length;
    }

}