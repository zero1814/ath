package org.module.shiro.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.module.helper.commons.LogHelper;
import org.module.model.system.user.SmUser;
import org.module.shiro.ShiroFilterUtils;

public class LoginFilter extends AccessControlFilter {
	final static Class<LoginFilter> CLASS = LoginFilter.class;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		SmUser token = (SmUser) SecurityUtils.getSubject().getPrincipal();
		if (null != token || isLoginRequest(request, response)) {// &&
			return Boolean.TRUE;
		}
		if (ShiroFilterUtils.isAjax(request)) {// ajax请求
			Map<String, String> resultMap = new HashMap<String, String>();
			LogHelper.debug(getClass(), "当前用户没有登录，并且是Ajax请求！");
			resultMap.put("login_status", "300");
			resultMap.put("message", "\u5F53\u524D\u7528\u6237\u6CA1\u6709\u767B\u5F55\uFF01");// 当前用户没有登录！
			ShiroFilterUtils.out(response, resultMap);
		}
		return Boolean.FALSE;

	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 保存Request和Response 到登录后的链接
		saveRequestAndRedirectToLogin(request, response);
		return Boolean.FALSE;
	}
}
