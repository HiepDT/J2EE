package com.osc.ejb.me.bean.remote;

import com.osc.ejb.me.pojo.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserSessionBeanRemote {
    void addUser(User user);
    List getUser();
}
