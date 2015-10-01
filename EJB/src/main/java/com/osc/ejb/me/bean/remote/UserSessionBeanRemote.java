package com.osc.ejb.me.bean.remote;

import com.osc.ejb.me.po.User;

import javax.ejb.Remote;
import java.util.List;

public interface UserSessionBeanRemote {
    void addUser(User user);
    List getUser();
}
