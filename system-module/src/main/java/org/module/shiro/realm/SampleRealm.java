package org.module.shiro.realm;

import java.util.Set;

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
import org.module.base.result.EntityResult;
import org.module.helper.LoggerHelper;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmRoleService;
import org.module.service.system.user.ISmUserService;
import org.module.shiro.token.ShiroToken;
import org.module.shiro.token.TokenManager;
import org.module.system.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 类: SampleRealm <br>
 * 描述: 用户验证 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月20日 下午3:12:00
 */
public class SampleRealm extends AuthorizingRealm {

	@Autowired
	private ISmUserService userService;
	@Autowired
	private ISmRoleService roleService;

	public SampleRealm() {
		super();
	}

	/**
	 * 认证信息，主要针对用户登录，
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		ShiroToken token = (ShiroToken) authcToken;
		EntityResult result = userService.login(token.getUsername(), token.getPswd());
		if (result.getCode() == 0) {
			SmUser user = (SmUser) result.getEntity();
			if (!StringUtils.equals(user.getStatus(), Constants.SUCCESS_STATUS)) {
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

		String userCode = TokenManager.getUserCode();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据用户ID查询角色（role），放入到Authorization里。
		Set<String> roles = roleService.findRoleByUserCode(userCode);
		info.setRoles(roles);
		// 根据用户ID查询权限（permission），放入到Authorization里。
		// Set<String> permissions = permissionService.findPermissionByUserId(userId);
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
