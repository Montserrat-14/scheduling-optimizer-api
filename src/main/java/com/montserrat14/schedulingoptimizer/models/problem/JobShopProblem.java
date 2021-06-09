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

    @Override
    public void createProblem(SchedulingSystem problemRequest) {

        this.problemRequest = problemRequest;

        setName("Job Shop Problem");

        this.length = problemRequest.getOrder().getTotalNumberOfOperations();
        setNumberOfVariables(this.length);
        setNumberOfObjectives(1); //FIXME: In the end we can add more objectives beyond makespan
        overallConstraintViolationDegree = new OverallConstraintViolation<>();
        numberOfViolatedConstraints = new NumberOfViolatedConstraints<>();

    }

    @Override
    public void evaluate(PermutationSolution<Integer>solution ) {
        Simulator sim = new Simulator(this.problemRequest);
        sim.run(solution);

        solution.setObjective(0,sim.getObjective());
        evaluateConstraints(solution, sim);
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
    public int getLength() {
        return this.length;
    }

}