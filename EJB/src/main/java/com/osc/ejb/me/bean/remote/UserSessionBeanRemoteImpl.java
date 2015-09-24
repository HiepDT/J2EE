package com.osc.ejb.me.bean.remote;

import com.osc.ejb.me.pojo.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserSessionBeanRemoteImpl implements UserSessionBeanRemote {
    List userList;

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public List getUser() {
        return userList;
    }
}
