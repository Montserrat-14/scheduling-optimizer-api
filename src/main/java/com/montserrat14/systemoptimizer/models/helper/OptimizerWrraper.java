package com.montserrat14.systemoptimizer.models.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.montserrat14.systemoptimizer.exception.SystemOptimizerException;
import com.montserrat14.systemoptimizer.models.SchedulingSystem;
import com.montserrat14.systemoptimizer.models.order.Order;
import com.montserrat14.systemoptimizer.models.resource.Resource;
import com.montserrat14.systemoptimizer.utils.Constants;
import org.json.JSONObject;

public final class OptimizerWrraper {

    private static final ObjectMapper objectMapper =  new ObjectMapper();

    public static Order getOrderFrom (String payload) throws SystemOptimizerException {

        try {
            JSONObject jsonObject = new JSONObject(payload);

            return objectMapper.readValue(jsonObject.get(Constants.PAYLOAD_ORDER).toString(), Order.class);

        } catch (NullPointerException | JsonProcessingException e) {
            throw new SystemOptimizerException("Fail to parse payload " + e.getMessage());
        }
    }

    public static Resource getResourceFrom (String payload) throws SystemOptimizerException {

        try {
            JSONObject jsonObject = new JSONObject(payload);

            return objectMapper.readValue(jsonObject.get(Constants.PAYLOAD_RESOURCE).toString(), Resource.class);

        } catch (NullPointerException | JsonProcessingException e) {
            throw new SystemOptimizerException("Fail to parse payload " + e.getMessage());
        }
    }

    public static SchedulingSystem getSchedulingSystemFrom (String payload) throws SystemOptimizerException {

        try {

            Order order = getOrderFrom(payload);
            Resource resource = getResourceFrom(payload);

            return new SchedulingSystem(order,resource);

        } catch (NullPointerException e) {
            throw new SystemOptimizerException("Fail to create SchedulingSystem object " + e.getMessage());
        }
    }

}
