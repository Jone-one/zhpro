package com.lyi.zhpro.common.shiro;

import com.lyi.zhpro.sys.service.UserService;
import com.lyi.zhpro.sys.vo.UserVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class AuthRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    /**
     * 权限验证方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份（登录）验证方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //通过令牌获取用户名
        String username = (String) authenticationToken.getPrincipal();
        UserVo userVo = userService.getUserByAccount(username);
        if (userVo == null) {
            throw new UnknownAccountException();
        } else if (userVo.getUserPwd().equals(authenticationToken.getCredentials())) {
            throw new IncorrectCredentialsException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userVo, userVo.getUserPwd(), this.getClass().getName());
        return simpleAuthenticationInfo;
    }
}
