package com.nexwise.entity;

import com.nexwise.dao.UsersMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UsersMapper usersMapper;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从主体传过来认证信息中，获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //获取主体密码
        String password = new String((char[]) authenticationToken.getCredentials());
        //通过用户名到数据库中获取凭证
        Users users = usersMapper.selectUserByUsername(username);
        if (users == null) {
            throw new UnknownAccountException("账号不存在");
        }
        if (!password.equals(users.getPassword())) {
            throw new IncorrectCredentialsException("密码错误");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(users, password, getName());

        return simpleAuthenticationInfo;
    }
}
