package com.fux.afk.auth.shiro;

import com.fux.afk.auth.entity.SysPermission;
import com.fux.afk.auth.entity.SysRole;
import com.fux.afk.auth.entity.SysUser;
import com.fux.afk.auth.service.PermissionService;
import com.fux.afk.auth.service.RoleService;
import com.fux.afk.auth.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuxj on 2019/3/6
 */
public class CustomRealm extends AuthorizingRealm {

    public static final String SESSION_USER_KEY = "FUX";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String username = (String) super.getAvailablePrincipal(principalCollection);
        List<String> roleList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        // 从数据库中获取当前登录用户的详细信息
        SysUser user = userService.getUser(username);
        if (null != user) {
            //获取用户角色
            List<SysRole> roles = roleService.getListByUserId(user.getId());
            for (SysRole role : roles) {
                roleList.add(role.getRoleName());
                //获取角色权限
                List<SysPermission> permissions = permissionService.getListByRoleId(role.getId());
                for (SysPermission permission : permissions) {
                    permissionList.add(permission.getCode());
                }
            }
        } else {
            throw new AuthorizationException();
        }
        // 为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(roleList);
        simpleAuthorInfo.addStringPermissions(permissionList);
        return simpleAuthorInfo;
    }

    /**
     * 认证回调函数，登录信息和用户验证信息验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从AdminController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        System.err.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        SysUser user = userService.getUser(token.getUsername());
        if(null != user) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), ByteSource.Util.bytes(user.getName()), user.getName());
            this.setSession(CustomRealm.SESSION_USER_KEY, user);
            return authcInfo;
        } else {
            //未找到账号
            throw new UnknownAccountException();
        }
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     *
     * @param key
     * @param value
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}
