package com.montserrat14.systemoptimizer;

import com.montserrat14.systemoptimizer.exception.SystemOptimizerException;
import com.montserrat14.systemoptimizer.models.SchedulingSystem;
import com.montserrat14.systemoptimizer.models.helper.OptimizerWrraper;
import com.montserrat14.systemoptimizer.models.order.Order;
import com.montserrat14.systemoptimizer.models.resource.Resource;
import com.montserrat14.systemoptimizer.utils.Constants;

public class Main {

    public static void main(String... args) throws SystemOptimizerException {

       Resource resource =  OptimizerWrraper.getResourceFrom(Constants.PAYLOAD);
       Order order = OptimizerWrraper.getOrderFrom(Constants.PAYLOAD);

       System.out.println(order.getName());
       System.out.println(resource.getType());

       SchedulingSystem shSchedulingSystem = OptimizerWrraper.getSchedulingSystemFrom(Constants.PAYLOAD);

        System.out.println(shSchedulingSystem.getOrder().getName());
        System.out.println(shSchedulingSystem.getResource().getType());


    }
}
