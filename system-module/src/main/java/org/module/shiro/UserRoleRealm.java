package org.module.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.module.commons.annotation.Inject;
import org.module.model.system.user.SmUser;

public class UserRoleRealm extends AuthorizingRealm {

	/**
	 * 
	 * 方法: doGetAuthorizationInfo <br>
	 * 描述: 认证回调函数,登录时调用
	 * 
	 * @param principal
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 用户名
		String username = (String) principal.getPrimaryPrincipal();
		/**
		 * 获取用户角色信息
		 */
		Set<String> roles = null;
		authorizationInfo.setRoles(roles);
		/**
		 * 获取用户权限信息
		 */
		Set<String> permissions = null;
		authorizationInfo.setStringPermissions(permissions);

		return authorizationInfo;
	}

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		String username = (String) token.getPrincipal();
		SmUser user = null;
		return info;
	}

}
