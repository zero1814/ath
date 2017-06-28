package org.module.shiro.manager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.module.model.system.user.SmUser;

public class TokenManager {

	/**
	 * 
	 * 方法: getToken <br>
	 * 描述: 获取当前登录的用户User对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:16:58
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
	 * 时间: 2017年6月27日 下午5:17:06
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
	 * 时间: 2017年6月27日 下午5:16:49
	 * 
	 * @return
	 */
	public static String getUserCode() {
		return getToken() == null ? null : getToken().getCode();
	}

	/**
	 * 把值放入到当前登录用户的Session里
	 * 
	 * @param key
	 * @param value
	 */
	public static void setVal2Session(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 
	 * 方法: getVal2Session <br>
	 * 描述: 从当前登录用户的Session里取值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:16:38
	 * 
	 * @param key
	 * @return
	 */
	public static Object getVal2Session(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 
	 * 方法: getVerificationCode <br>
	 * 描述: 获取验证码，获取一次后删除 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:15:41
	 * 
	 * @return
	 */
	public static String getVerificationCode() {
		String code = (String) getSession().getAttribute("CODE");
		getSession().removeAttribute("CODE");
		return code;
	}

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:16:09
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
	 * 时间: 2017年6月27日 下午5:16:20
	 * 
	 * @return
	 */
	public static boolean isLogin() {
		return null != SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 
	 * 方法: logout <br>
	 * 描述: 退出登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:16:29
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
}
