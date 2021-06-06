package com.montserrat14.schedulingoptimizer;

import com.montserrat14.schedulingoptimizer.exception.SystemOptimizerException;
import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.helper.OptimizerWrraper;
import com.montserrat14.schedulingoptimizer.simulator.Simulator;
import com.montserrat14.schedulingoptimizer.simulator.SimulatorJob;
import com.montserrat14.schedulingoptimizer.utils.Constants;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.solution.permutationsolution.impl.IntegerPermutationSolution;

public class Main {

    public static void main(String... agrs) throws SystemOptimizerException {

        SchedulingSystem schedulingSystem = OptimizerWrraper.getSchedulingSystemFrom(Constants.PAYLOAD);

        Simulator simulator = new Simulator(schedulingSystem);

        IntegerPermutationSolution integerPermutationSolution = new IntegerPermutationSolution(8,1);

        integerPermutationSolution.setVariable(0,3);
        integerPermutationSolution.setVariable(1,6);
        integerPermutationSolution.setVariable(2,4);
        integerPermutationSolution.setVariable(3,0);
        integerPermutationSolution.setVariable(4,7);
        integerPermutationSolution.setVariable(5,1);
        integerPermutationSolution.setVariable(6,5);
        integerPermutationSolution.setVariable(7,2);

        simulator.run(integerPermutationSolution);

        for (SimulatorJob job : simulator.getSimulatorJobList()){

            System.out.println(job.getEndTime());
        }

    }
}
