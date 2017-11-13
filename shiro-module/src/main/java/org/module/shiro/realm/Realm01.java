package org.module.shiro.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class Realm01 implements Realm {

	/**
	 * 
	 * 方法: getName <br>
	 * 描述: 返回一个唯一的 Realm 名字
	 * 
	 * @return
	 * @see org.apache.shiro.realm.Realm#getName()
	 */
	@Override
	public String getName() {
		return "realm01";
	}

	/**
	 * 
	 * 方法: supports <br>
	 * 描述: 判断此 Realm 是否支持此 Token
	 * 
	 * @param token
	 * @return
	 * @see org.apache.shiro.realm.Realm#supports(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	/**
	 * 
	 * 方法: getAuthenticationInfo <br>
	 * 描述: 根据 Token 获取认证信息
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.Realm#getAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 得到用户名
		String username = (String) token.getPrincipal();
		// 得到密码
		String password = (String) token.getCredentials();
		if (StringUtils.equals(username, "zhang")) {
			throw new UnknownAccountException(); // 如果用户名错误
		} else if (StringUtils.equals(password, "123")) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}
		// 如果身份认证验证成功，返回一个 AuthenticationInfo 实现；
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
