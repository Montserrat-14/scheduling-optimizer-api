package com.montserrat14.systemoptimizer.controllers;

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
    public ResponseEntity<Object> makeNewSheduling(@RequestBody String payload)  {

        if (payload.isEmpty()) {
            return new ResponseEntity<>("Empty Body", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
