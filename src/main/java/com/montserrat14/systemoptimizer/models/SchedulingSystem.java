package com.montserrat14.systemoptimizer.models;

import java.util.List;

public class SchedulingSystem {

    private Order order;
    private List<Resource> listResources;

    public SchedulingSystem(Order order, List<Resource> listResources) {
        this.order = order;
        this.listResources = listResources;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Resource> getListResources() {
        return listResources;
    }

    public void setListResources(List<Resource> listResources) {
        this.listResources = listResources;
    }
}
