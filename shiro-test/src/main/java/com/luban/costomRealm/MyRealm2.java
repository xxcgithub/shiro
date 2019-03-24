package com.luban.costomRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Create by xxc on 2019/3/22 22:50
 */
public class MyRealm2 extends AuthorizingRealm {
    Map<String,String> map = new HashMap<>();
    {
        map.put("xiao","e2f5e798186344470f784f353a80ef7f");

    }

    @Override
    public String getName (){
        return "custom";
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username  = (String) principalCollection.getPrimaryPrincipal();

        //genju名字取用户角色
        Set<String> roleWithUsername = getRoleWithUsername(username);

        //根据名字取权限

        Set<String> permissions = getpermissionWithName(username);

        //创建授权信息返回

        SimpleAuthorizationInfo simpleAuthorizationInfo =
                new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleWithUsername);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    private Set<String> getpermissionWithName(String username) {
        Set<String> set2 = new HashSet<>();
        set2.add("user:delete");
        return set2;
    }

    private Set<String> getRoleWithUsername(String username) {
        Set<String> set1 = new HashSet<>();
        set1.add("user");
        return set1;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username  = (String) authenticationToken.getPrincipal();
        String password = getPasswordWith(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo("xiao",password,getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("xiao"));




        return simpleAuthenticationInfo;
    }

    private String getPasswordWith(String username) {
        return  map.get(username);
    }
}
