package org.module.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * 类: UserRealm <br>
 * 描述: 用户权限验证 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月13日 上午11:25:21
 */
public class UserRealm extends AuthorizingRealm {

	/**
	 * 
	 * 方法: doGetAuthorizationInfo <br>
	 * 描述: 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
	 * 
	 * @param principal
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// 获取登录时输入的用户名
		String loginName = (String) principal.fromRealm(getName()).iterator().next();
		// 根据用户名查询用户信息
		Object user = null;
		if (user != null) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			info.setRoles(null);
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
			List<Object> roleList = null;
			for (Object role : roleList) {
				info.addStringPermissions(null);
			}
			return info;
		}
		return null;
	}

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 登录信息和用户验证信息验证
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		// UsernamePasswordToken对象用来存放提交的登录信息
		UsernamePasswordToken token = (UsernamePasswordToken) auth;
		// 查出是否有此用户 token.getUsername()
		Object user = null;
		if (user != null) {
			// 若存在，将此用户存放到登录认证info中
			// user.getUsername(), user.getPassword(), getName()
			return new SimpleAuthenticationInfo(null, null, "");
		}
		return null;
	}

}
