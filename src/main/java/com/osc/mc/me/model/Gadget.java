package com.osc.mc.me.model;


public class Gadget {
    //DI
    String description;

    public Gadget(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Autowired shit. It says: " + description;
    }
}
