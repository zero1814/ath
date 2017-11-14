package org.module.shiro.token;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.module.model.system.user.SmUser;

public class TokenManager {

	/**
	 * 
	 * 方法: getToken <br>
	 * 描述: 获取当前登录的用户User对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:34:22
	 * 
	 * @return
	 */
	public static SmUser getToken() {
		SmUser token = (SmUser) SecurityUtils.getSubject().getPrincipal();
		return token;
	}

	/**
	 * 
	 * 方法: getSession <br>
	 * 描述: 获取当前用户的Session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:34:40
	 * 
	 * @return
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 
	 * 方法: getUserCode <br>
	 * 描述: 获取当前用户编码 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:35:12
	 * 
	 * @return
	 */
	public static String getUserCode() {
		return getToken() == null ? null : getToken().getCode();
	}

	/**
	 * 
	 * 方法: setValToSession <br>
	 * 描述: 把值放入到当前登录用户的Session里 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:41:53
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 
	 * 方法: getVal2Session <br>
	 * 描述: 从当前登录用户的Session里取值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:42:14
	 * 
	 * @param key
	 * @return
	 */
	public static Object getValue(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:43:20
	 * 
	 * @param user
	 * @param rememberMe
	 * @return
	 */
	public static SmUser login(SmUser user, Boolean rememberMe) {
		ShiroToken token = new ShiroToken(user.getUserName(), user.getPassword());
		token.setRememberMe(rememberMe);
		SecurityUtils.getSubject().login(token);
		return getToken();
	}

	/**
	 * 
	 * 方法: isLogin <br>
	 * 描述: 判断是否登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午4:43:36
	 * 
	 * @return
	 */
	public static boolean isLogin() {
		return null != SecurityUtils.getSubject().getPrincipal();
	}

}
