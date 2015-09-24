package com.osc.mc.me.action;

import com.opensymphony.xwork2.ActionSupport;
import com.osc.mc.me.model.Gadget;
import com.osc.mc.me.model.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;

public class Welcome extends ActionSupport {
    // DI
    UserTypes userType;
    Gadget gadget;

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public Gadget getGadget() {
        return gadget;
    }

    @Autowired
    public Welcome(Gadget gadget) {
        this.gadget = gadget;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
