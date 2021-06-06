package com.montserrat14.schedulingoptimizer.controllers;

import com.montserrat14.schedulingoptimizer.exception.SystemOptimizerException;
import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.order.Order;
import com.montserrat14.schedulingoptimizer.models.helper.OptimizerWrraper;
import com.montserrat14.schedulingoptimizer.models.resource.Resource;
import com.montserrat14.schedulingoptimizer.simulator.Simulator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.solution.integersolution.impl.DefaultIntegerSolution;
import org.uma.jmetal.solution.permutationsolution.impl.IntegerPermutationSolution;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "http://localhost:80"})
@RestController
public class SchedulingController {

    @RequestMapping(
            value = "/sheduling",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> makeNewSheduling(@RequestBody String payload) throws SystemOptimizerException {

        if (payload.isEmpty()) {
            return new ResponseEntity<>("Empty Body", HttpStatus.NOT_ACCEPTABLE);
        }

        try {
            Resource resource =  OptimizerWrraper.getResourceFrom(payload);
            Order order = OptimizerWrraper.getOrderFrom(payload);

            System.out.println(order.getName());
            System.out.println(resource.getType());

            SchedulingSystem schedulingSystem = OptimizerWrraper.getSchedulingSystemFrom(payload);

            System.out.println(schedulingSystem.getOrder().getName());
            System.out.println(schedulingSystem.getResource().getType());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
