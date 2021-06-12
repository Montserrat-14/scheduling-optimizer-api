package com.montserrat14.schedulingoptimizer.controllers;

import com.montserrat14.schedulingoptimizer.algorithms.RunAlgorithmService;
import com.montserrat14.schedulingoptimizer.exception.SchedulingOptimizerException;
import com.montserrat14.schedulingoptimizer.models.SchedulingSystem;
import com.montserrat14.schedulingoptimizer.models.helper.OptimizerWrapper;

import com.montserrat14.schedulingoptimizer.simulator.Simulator;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;


@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "http://localhost:80"})
@RestController
public class SchedulingController {

    @RequestMapping(
            value = "/sheduling",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> makeNewSheduling(@RequestBody String payload) throws SchedulingOptimizerException {

        if (payload.isEmpty()) {
            return new ResponseEntity<>("Empty Body", HttpStatus.NOT_ACCEPTABLE);
        }

        try {

            SchedulingSystem schedulingSystem = OptimizerWrapper.getSchedulingSystemFrom(payload);

            return ResponseEntity.status(HttpStatus.OK).body(RunAlgorithmService.run(schedulingSystem).toString());

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
