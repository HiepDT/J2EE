package com.osc.ejb.me.bean.remote;

import com.osc.ejb.me.po.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name="SimpleEJB")
@Remote(UserSessionBeanRemote.class)
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
