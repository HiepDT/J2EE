package com.osc.mc.me.action;

import com.opensymphony.xwork2.ActionSupport;
import com.osc.mc.me.model.Gadget;
import com.osc.mc.me.model.ScanmeBabe;
import com.osc.mc.me.model.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Welcome extends ActionSupport {
    // DI
    UserTypes userType;
    Gadget gadget;
    ScanmeBabe autoScanned;

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public Gadget getGadget() {
        return gadget;
    }

    public ScanmeBabe getAutoScanned() {
        return autoScanned;
    }

    @Autowired
    public Welcome(Gadget gadget, ScanmeBabe autoScanned) {
        this.gadget = gadget;
        this.autoScanned = autoScanned;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
