package com.montserrat14.schedulingoptimizer.models;

import com.montserrat14.schedulingoptimizer.models.order.Order;
import com.montserrat14.schedulingoptimizer.models.resource.Resource;

public class SchedulingSystem {

    private Order order;
    private Resource resource;

    public SchedulingSystem() {

    }

    public SchedulingSystem(Order order, Resource resource) {
        this.order = order;
        this.resource = resource;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }


}
