package com.montserrat14.systemoptimizer.controllers;

import com.montserrat14.systemoptimizer.exception.SystemOptimizerException;
import com.montserrat14.systemoptimizer.models.SchedulingSystem;
import com.montserrat14.systemoptimizer.models.helper.OptimizerWrraper;
import com.montserrat14.systemoptimizer.models.order.Order;
import com.montserrat14.systemoptimizer.models.resource.Resource;
import com.montserrat14.systemoptimizer.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Resource resource =  OptimizerWrraper.getResourceFrom(Constants.PAYLOAD);
        Order order = OptimizerWrraper.getOrderFrom(Constants.PAYLOAD);

        System.out.println(order.getName());
        System.out.println(resource.getType());

        SchedulingSystem schedulingSystem = OptimizerWrraper.getSchedulingSystemFrom(Constants.PAYLOAD);

        System.out.println(schedulingSystem.getOrder().getName());
        System.out.println(schedulingSystem.getResource().getType());

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
