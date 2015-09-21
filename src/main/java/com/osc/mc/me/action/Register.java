package com.osc.mc.me.action;

import com.opensymphony.xwork2.ActionSupport;
import com.osc.mc.me.model.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by HiepDT on 9/11/2015.
 */
public class Register extends ActionSupport {
    private String username;
    private String password;
    private static final String PERSISTENCE_UNIT_NAME = "MyJPA";
    private static EntityManagerFactory factory;

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
        LOG.info("Username and password (before persisting) " + username + " " + password);
        em.getTransaction().begin();

        //Spring
        WebApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        ServletActionContext.getServletContext()
                );
        User user = (User) context.getBean("User");
        user.setUsername(username);
        user.setPassword(password);
        em.persist(user);
        em.getTransaction().commit();
        return SUCCESS;

    }
}
