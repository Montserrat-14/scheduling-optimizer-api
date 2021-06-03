package com.montserrat14.schedulingoptimizer.models.resource;

import java.util.List;

public class Resource {

    private String type;
    private List<Resources> resources;

    public Resource() {
    }

    public Resource(String type, List<Resources> resources) {
        this.type = type;
        this.resources = resources;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Resources> getResources() {
        return resources;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }
}
