package com.montserrat14.schedulingoptimizer.models.problem.factory;

import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.simulator.Simulator;

public interface ISchedulingProblem {

    void createProblem(SchedulingSystem problemRequest);
    SchedulingSystem getProblem();
    Simulator getSimulator();
}
