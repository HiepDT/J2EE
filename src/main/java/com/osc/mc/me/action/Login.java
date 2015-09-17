package com.osc.mc.me.action;

import com.opensymphony.xwork2.ActionSupport;
import com.osc.mc.me.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Login extends ActionSupport {
    private static final String PERSISTENCE_UNIT_NAME = "MyJPA";
    private static EntityManagerFactory factory;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :login AND u.password = :pass");
        q.setParameter("login", username);
        q.setParameter("pass", password);
        try {
            User user = (User) q.getSingleResult();
            if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
                return SUCCESS;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
