package com.luban.shiro1;

import com.luban.costomRealm.MyRealm;
import com.luban.costomRealm.MyRealm2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Create by xxc on 2019/3/22 22:06
 */
public class CustomRealmTest {

    /*@Test
    public void  getTest () {
        MyRealm myRealm = new MyRealm();

        //环境

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xiao","123");

        subject.login(token);

        System.out.println(subject.isAuthenticated());
        *//*subject.checkPermission("user:delete");
        subject.checkRole("user");
        subject.checkPermission("admin:*");*//*
    }

*/
    @Test
    public  void  getTest (){
        //首先需要环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        MyRealm2 myRealm2 = new MyRealm2();



        defaultSecurityManager.setRealm(myRealm2);

        HashedCredentialsMatcher hashedCredentialsMatcher=
                new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        myRealm2.setCredentialsMatcher(hashedCredentialsMatcher);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xiao","123");
        subject.login(token);

        System.out.println(subject.isAuthenticated());
        System.out.println(subject.hasRole("user"));

        subject.checkPermission("user:delete");


    }

}
