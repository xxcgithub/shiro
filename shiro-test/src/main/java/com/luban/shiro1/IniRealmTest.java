package com.luban.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import javax.swing.*;

/**
 * Create by xxc on 2019/3/21 21:25
 */
public class IniRealmTest {
    @Test
    public  void  getTest (){
        //首先需要环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xiao","123");
        subject.login(token);

        System.out.println(subject.isAuthenticated());
        System.out.println(subject.hasRole("admin"));

        subject.checkPermission("user:update");



    }
}
