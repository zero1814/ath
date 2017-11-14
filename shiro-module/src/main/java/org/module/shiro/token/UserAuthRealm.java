package org.module.shiro.token;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.module.base.result.EntityResult;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthRealm extends AuthorizingRealm {

	@Autowired
	private ISmUserService userService;

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 认证信息，主要针对用户登录
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
		SmUserDto dto = new SmUserDto();
		dto.setUserName(token.getUsername());
		dto.setPassword(String.valueOf(token.getPassword()));
		EntityResult result = userService.selectEntity(dto);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			SmUser user = (SmUser) result.getEntity();
			return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		} else {
			throw new AccountException("帐号或密码不正确！");
		}
	}

	/**
	 * 
	 * 方法: doGetAuthorizationInfo <br>
	 * 描述: 用户授权
	 * 
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		return info;
	}

}
