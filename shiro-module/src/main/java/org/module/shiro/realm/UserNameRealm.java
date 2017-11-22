package org.module.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.module.commons.annotation.Inject;
import org.module.commons.result.EntityResult;
import org.module.commons.util.Constant;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.springframework.stereotype.Component;

/**
 * 
 * 类: UserNameRealm <br>
 * 描述: 用户名登录验证 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月14日 上午8:57:15
 */
@Component
public class UserNameRealm extends AuthorizingRealm {

	@Inject
	private ISmUserService userService;

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 获取身份验证相关信息
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();// 用户名
		String password = (String) token.getCredentials();// 密码
		SmUserDto dto = new SmUserDto();
		dto.setUserName(userName);
		dto.setPassword(password);
		EntityResult result = userService.login(dto);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			SmUser user = (SmUser) result.getEntity();
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(), // 用户名
					user.getPassword(), // 密码
					getName() // realm name
			);
			return info;
		} else {
			throw new UnknownAccountException();// 没找到帐号
		}

	}

	/**
	 * 
	 * 方法: doGetAuthorizationInfo <br>
	 * 描述: doGetAuthorizationInfo
	 * 
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
