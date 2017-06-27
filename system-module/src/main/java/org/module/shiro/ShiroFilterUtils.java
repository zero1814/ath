package org.module.shiro;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.module.helper.commons.LogHelper;

import net.sf.json.JSONObject;

public class ShiroFilterUtils {

	/**
	 * 
	 * 方法: isAjax <br>
	 * 描述: 是否是Ajax请求 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:17:32
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjax(ServletRequest request) {
		return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
	}

	/**
	 * 
	 * 方法: out <br>
	 * 描述: response 输出JSON <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月27日 下午5:17:44
	 * 
	 * @param response
	 * @param resultMap
	 */
	public static void out(ServletResponse response, Map<String, String> resultMap) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(JSONObject.fromObject(resultMap).toString());
		} catch (Exception e) {
			LogHelper.error(ShiroFilterUtils.class, e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}
}
