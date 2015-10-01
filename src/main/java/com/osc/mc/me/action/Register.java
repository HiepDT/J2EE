package com.osc.mc.me.action;

import com.osc.ejb.me.bean.remote.UserSessionBeanRemote;
import com.osc.mc.me.model.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class Register extends JNDIInit {
    private String username;
    private String password;
    private String msg;
    private boolean jboss;
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

    public String getMsg() {
        return msg;
    }

    public boolean isJboss() {
        return jboss;
    }

    public void setJboss(boolean jboss) {
        this.jboss = jboss;
    }

    public String execute() throws Exception {
        if (!jboss) {
            persistJPAWay();
            msg = "JPA'ed";
        } else {
            final String appName = "EJB-1.0";
            final String moduleName = "EJB-1.0";
            final String distinctName = "";
            final String beanName = "SimpleEJB";

            final String viewClassName = UserSessionBeanRemote.class.getName();

            UserSessionBeanRemote userSessionBeanRemote =
                    (UserSessionBeanRemote) ctx.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
            ctx.close();
            WebApplicationContext context =
                    WebApplicationContextUtils.getRequiredWebApplicationContext(
                            ServletActionContext.getServletContext()
                    );
            com.osc.mc.me.model.User user = (com.osc.mc.me.model.User) context.getBean("User");
            user.setUsername(username);
            user.setPassword(password);
            userSessionBeanRemote.addUser(new com.osc.ejb.me.po.User(username, password));
            msg = "EJB'ed";
        }
        return "success";

    }

    private void persistJPAWay() {
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
    }
}
