package org.module.shiro;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.module.base.result.EntityResult;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.module.util.Constant;
import org.module.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 类: UserAuthRealm <br>
 * 描述: 重写AuthorizingRealm <br>
 * 作者: zhy<br>
 * 时间: 2017年11月10日 下午3:53:11
 */
public class UserAuthRealm extends AuthorizingRealm {

	@Autowired
	private ISmUserService service;

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 用户登录认证
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		SmUserDto dto = new SmUserDto();
		dto.setUserName("admin");
		dto.setPassword(MD5Util.md5Hex("888888"));
		EntityResult result = service.selectEntity(dto);
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
		return null;
	}

}
