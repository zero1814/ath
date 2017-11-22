package org.module.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.module.commons.BaseLog;
import org.module.commons.helper.PropHelper;
import org.module.controller.LoginController;
import org.module.controller.VerificationCodeController;
import org.module.model.system.user.SmUser;
import org.module.system.factory.UserFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * 类: LoginInterceptor <br>
 * 描述: 登录拦截器 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月6日 下午3:20:54
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	public static BaseLog logger = new BaseLog();

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 这个主要是判断当前连接的是不是业务类的控制器， 如果是springmvc静态资源的handler， 在转成HandlerMethod时就会报错.
		 * 
		 */
		if (HandlerMethod.class.equals(handler.getClass())) {
			// 获取controller，判断是不是实现登录接口的控制器
			HandlerMethod method = (HandlerMethod) handler;
			Object controller = method.getBean();
			if (!(controller instanceof VerificationCodeController) && !(controller instanceof LoginController)) {
				SmUser user = UserFactory.userInfo();
				if (user == null) {
					logger.logDebug("-----------未登录访问   跳回登录页面----");
					request.getRequestDispatcher(PropHelper.getConfig("web.login")).forward(request, response);
					return false;
				}
			}
		}
		return true;
	}

}
