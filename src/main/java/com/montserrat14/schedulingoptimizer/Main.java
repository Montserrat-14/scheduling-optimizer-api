package com.montserrat14.schedulingoptimizer;

import com.montserrat14.schedulingoptimizer.exception.SchedulingOptimizerException;
import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.helper.OptimizerWrapper;
import com.montserrat14.schedulingoptimizer.simulator.Simulator;
import com.montserrat14.schedulingoptimizer.utils.Constants;
import org.uma.jmetal.solution.permutationsolution.impl.IntegerPermutationSolution;

public class Main {

    public static void main(String... agrs) throws SchedulingOptimizerException {

        SchedulingSystem schedulingSystem = OptimizerWrapper.getSchedulingSystemFrom(Constants.PAYLOAD);

        Simulator simulator = new Simulator(schedulingSystem);

        IntegerPermutationSolution integerPermutationSolution = new IntegerPermutationSolution(8,1);

        integerPermutationSolution.setVariable(0,3);
        integerPermutationSolution.setVariable(1,7);
        integerPermutationSolution.setVariable(2,7);
        integerPermutationSolution.setVariable(3,7);
        integerPermutationSolution.setVariable(4,3);
        integerPermutationSolution.setVariable(5,2);
        integerPermutationSolution.setVariable(6,5);
        integerPermutationSolution.setVariable(7,0);

        simulator.run(integerPermutationSolution);

        System.out.println("Makespan: " + simulator.getObjective());

    }
}
