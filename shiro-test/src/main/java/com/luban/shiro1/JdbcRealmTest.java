package com.luban.shiro1;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Create by xxc on 2019/3/21 22:17
 */
public class JdbcRealmTest {

    @Test
    public void  getTest (){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        JdbcRealm jdbcRealm = new JdbcRealm();
        DruidDataSource druidDataSource = new DruidDataSource();
        {
            druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            druidDataSource.setUrl("jdbc:mysql:///testJdbcRealm");
            druidDataSource.setUsername("root");
            druidDataSource.setPassword("root");


        }
        jdbcRealm.setPermissionsLookupEnabled(true);
        String userSql = "select password from user_test where username = ?";
        jdbcRealm.setAuthenticationQuery(userSql);

        String roleSql = "select user_role  from uesr_role where  username = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        String peimisionSql = "select user_permition from user_permition where role= ？ ";
        jdbcRealm.setPermissionsQuery(peimisionSql);

        jdbcRealm.setDataSource(druidDataSource);

        defaultSecurityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken("xiao","123");

        subject.login(token);

        System.out.println(subject.isAuthenticated());
        subject.checkPermission("user:update");
        subject.checkRoles("user","admin");
    }
}
