package com.luban.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Create by xxc on 2019/3/21 10:50
 */
public class SecurityManager {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void  addUser (){
        simpleAccountRealm.addAccount("xxc","xxc");
    }

    @Test
    public void testAuthentication(){
        //1,安全管理
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xxc","xxc");
        token.setRememberMe(true);
        subject.login(token);

        if (subject.isAuthenticated()){
            System.out.println(true);
        }

    }

}
