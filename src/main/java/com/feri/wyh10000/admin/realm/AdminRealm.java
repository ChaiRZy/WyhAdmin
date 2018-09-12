package com.feri.wyh10000.admin.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/9/12 14:29
 * 用户数据源
 * 1、认证
 *      登录校验
 * 2、授权
 *      当前用户的角色或权限
 */
@Service
public class AdminRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
        return simpleAuthenticationInfo;
    }
}
