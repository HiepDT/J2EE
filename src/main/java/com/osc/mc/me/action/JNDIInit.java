package com.osc.mc.me.action;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


public class JNDIInit {

    @Resource(name = "JNDIProps")
    private Properties JNDIProps;

    protected static Logger LOG = LoggerFactory.getLogger(JNDIInit.class);
    InitialContext ctx;
    {
        try {
            ctx = new InitialContext(JNDIProps);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
}
