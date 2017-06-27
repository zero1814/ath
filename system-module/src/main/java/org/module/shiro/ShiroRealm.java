package org.module.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.module.commons.annotation.Inject;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.service.system.user.ISmUserService;

public class ShiroRealm extends AuthorizingRealm {
	@Inject
	private ISmUserService userService;

	public ShiroRealm() {
		super();
	}

	/**
	 * 
	 * 方法: doGetAuthorizationInfo <br>
	 * 描述: 实现用户的授权逻辑<br>
	 * 
	 * @param principal
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		return null;
	}

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 实现用户登录时的认证逻辑<br>
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		ShiroToken token = (ShiroToken) authcToken;
		EntityResult result = userService.login(token.getUsername(), token.getPswd());
		if (result.getCode() == 0) {
			SmUser user = (SmUser) result.getEntity();
			return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		} else {
			return null;
		}
	}

}
