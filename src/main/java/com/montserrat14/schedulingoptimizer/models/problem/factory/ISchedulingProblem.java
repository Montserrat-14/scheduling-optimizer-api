package com.montserrat14.schedulingoptimizer.models.problem.factory;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;

public interface ISchedulingProblem {

    void createProblem(SchedulingSystem problemRequest);
    SchedulingSystem getProblem();
}
