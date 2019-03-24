package com.luban.costomRealm;

import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import java.util.Set;

/**
 * Create by xxc on 2019/3/22 21:18
 */
public class MyRealm extends AuthorizingRealm {

   Map map = new HashMap();
    {
        map.put("xiao","202cb962ac59075b964b07152d234b70");
        super.setName("custom");
    }



    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*String username = (String) principalCollection.getPrimaryPrincipal();

        //通过name 获得角色
        Set<java.lang.String> roles = getRoles(username);

        //通过名字获得权限
        Set<java.lang.String> permitions = getPermission(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permitions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    private Set<java.lang.String> getPermission(String username) {
        //模拟数据库
        Set<java.lang.String> set2 = new HashSet<>();
        set2.add("user:update");
        set2.add("user.delete");
        set2.add("admin:*");
        return set2;
    }

    private Set<java.lang.String> getRoles(String username) {
        //模拟数据库
        Set<java.lang.String> set1 = new HashSet<>();
        set1.add("user");
        set1.add("admin");
        return set1;
     }*/
        return null;
    }


    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String)authenticationToken.getPrincipal();

        String passWord = getPassWord(principal);
        if (passWord == null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("xiao",passWord,"custom");
        //simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("xiao"));

        return simpleAuthenticationInfo;

    }
    private String getPassWord(String userName) {
        return (String) map.get(userName);
    }


}
