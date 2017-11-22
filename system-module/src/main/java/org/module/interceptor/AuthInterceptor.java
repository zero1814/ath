package org.module.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.module.commons.annotation.SKipAuthPassport;
import org.module.commons.helper.PropHelper;
import org.module.model.system.user.SmUser;
import org.module.system.factory.UserFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * 类: AuthInterceptor <br>
 * 描述: 用户登录验证拦截 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月6日 下午5:03:18
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = true;
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			SKipAuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(SKipAuthPassport.class);
			// 如果authPassport为空或validate=false表示需要验证
			if (authPassport == null || authPassport.validate() == false) {
				SmUser user = UserFactory.userInfo();
				if (user == null) {
					request.getRequestDispatcher(PropHelper.getConfig("web.login")).forward(request, response);
					flag = false;
				}
			}
		} else {
			flag = true;
		}
		return flag;
	}
}
