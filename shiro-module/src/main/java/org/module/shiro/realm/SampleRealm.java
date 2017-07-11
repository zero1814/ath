package org.module.shiro.realm;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.module.factory.system.UserFactory;
import org.module.helper.commons.LoggerHelper;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.shiro.token.ShiroToken;


/**
 * 
 * 类: SampleRealm <br>
 * 描述: shiro 认证 + 授权 重写 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:56:11
 */
public class SampleRealm extends AuthorizingRealm {

	public SampleRealm() {
		super();
	}

	/**
	 * 认证信息，主要针对用户登录，
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		ShiroToken token = (ShiroToken) authcToken;
		EntityResult result = UserFactory.instance().login(token.getUsername(), token.getPswd());
		if (result.getCode() == 0) {
			SmUser user = (SmUser) result.getEntity();
			if (!StringUtils.equals(user.getStatus(), SmUser.SUCCESS_STATUS)) {
				throw new DisabledAccountException("帐号已经禁止登录！");
			} else {
				/**
				 * 添加登录日志
				 */
				LoggerHelper.info(getClass(), "用户名密码验证通过！");
				return new SimpleAuthenticationInfo(result.getEntity(), user.getPassword(), getName());
			}
		} else {
			throw new AccountException("帐号或密码不正确！");
		}
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// String userCode = TokenManager.getUserCode();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据用户ID查询角色（role），放入到Authorization里。
		// Set<String> roles = roleService.findRoleByUserId(userId);
		// info.setRoles(roles);
		// // 根据用户ID查询权限（permission），放入到Authorization里。
		// Set<String> permissions =
		// permissionService.findPermissionByUserId(userId);
		// info.setStringPermissions(permissions);
		return info;
	}

	/**
	 * 清空当前用户权限信息
	 */
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	
	
}
