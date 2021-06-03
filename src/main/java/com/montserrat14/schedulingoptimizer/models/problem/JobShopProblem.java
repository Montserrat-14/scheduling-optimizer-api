package com.montserrat14.schedulingoptimizer.models.problem;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.problem.factory.ISchedulingProblem;
import org.uma.jmetal.problem.integerproblem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;

public class JobShopProblem extends AbstractIntegerProblem implements ISchedulingProblem {

    private SchedulingSystem problemRequest;

    @Override
    public void createProblem(SchedulingSystem problemRequest) {

        this.problemRequest = problemRequest;

        setName("Job Shop Problem");

        setNumberOfVariables(problemRequest.getOrder().getTotalNumberOfOperations());
        setNumberOfObjectives(1); //FIXME: In the end we can add more objectives beyond makespan

    }

    @Override
    public void evaluate(IntegerSolution integerSolution) {
        //TODO: Run Simulator
        //TODO: Set Objectives
        //TODO: Set Constraints

    }

    public SchedulingSystem getProblem() {
        return this.problemRequest;
    }

}