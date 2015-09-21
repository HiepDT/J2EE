package com.osc.mc.me.action;

import com.opensymphony.xwork2.ActionSupport;
import com.osc.mc.me.model.UserTypes;

public class Welcome extends ActionSupport {
    // DI
    UserTypes userType;

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
