package com.montserrat14.schedulingoptimizer.models.problem.factory;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.problem.JobShopProblem;


public class SchedulingProblemFactory {

    public ISchedulingProblem getProblem(SchedulingSystem request){

        JobShopProblem newProblem = new JobShopProblem();
        newProblem.createProblem(request);

        return newProblem;

    }
}