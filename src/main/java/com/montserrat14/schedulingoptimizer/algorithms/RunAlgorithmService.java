package com.montserrat14.schedulingoptimizer.algorithms;

import com.montserrat14.schedulingoptimizer.exception.AlgorithmsException;
import com.montserrat14.schedulingoptimizer.exception.SchedulingOptimizerException;
import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.problem.factory.ISchedulingProblem;
import com.montserrat14.schedulingoptimizer.models.problem.factory.SchedulingProblemFactory;

import java.util.HashMap;

public class RunAlgorithmService {

    private static final String ALG_NAME = "NSGAII";

    private static AlgorithmGenericBuilder algBuilder = new AlgorithmGenericBuilder();

    public static HashMap<String, Object> run(SchedulingSystem schedulingSystem) throws AlgorithmsException, SchedulingOptimizerException {


        SchedulingProblemFactory problemFactory = new SchedulingProblemFactory();
        ISchedulingProblem newProblem = problemFactory.getProblem(schedulingSystem);

        algBuilder.setProblem(newProblem);

        startAlgorithm(ALG_NAME.toLowerCase(), newProblem.getProblem().getOrder().getDuration());

        return algBuilder.getResponse();
    }

    private static boolean startAlgorithm(String algName, int problemTime) {

        try {
            double evaluationTime = algBuilder.findSpecificAlgorithm(algName).setConstructors().setInstance()
                    .getMaxMethod().setMaxEvals(1)
                    .runAlgorithm().getLastTimeExecution();

            double problemTimeInSeconds = problemTime * 60;
            int iterations = (int)(problemTimeInSeconds / evaluationTime);

            System.out.println("Iterations: " + iterations);

            algBuilder.setMaxEvals(iterations).runAlgorithm().getResults();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
