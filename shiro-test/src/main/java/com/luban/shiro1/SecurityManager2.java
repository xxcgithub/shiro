package com.luban.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Create by xxc on 2019/3/21 20:33
 */
public class SecurityManager2 {


    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    @Before
    public void addUser (){
        simpleAccountRealm.addAccount("xiaoming","123456","admin","user");
    }
    @Test
    public  void  getAuthentication(){
        DefaultSecurityManager defaultSecurityManager  = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xiaoming","123456");

        subject.login(token);

        if (subject.isAuthenticated()){
            System.out.println(subject.isAuthenticated());
        }



        subject.checkRoles("user","admin");
        if (subject.hasRole("admin")){
            System.out.println("拥有admin 的权限");
        }
    }


}
