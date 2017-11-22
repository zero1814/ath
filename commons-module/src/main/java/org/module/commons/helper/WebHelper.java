package org.module.commons.helper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * 类: WebHelper <br>
 * 描述: web相关帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月6日 下午2:45:33
 */
public class WebHelper {

	public static String getIpAddress() {
		String ip = "";
		try {
			InetAddress address = InetAddress.getLocalHost();
			ip = address.getHostAddress();
		} catch (UnknownHostException e) {
			LoggerHelper.error(WebHelper.class, "获取ip地址报错，错误原因:" + e.getMessage());
			e.printStackTrace();
		}
		return ip;
	}

	public static HttpServletRequest getRequest() {
		HttpServletRequest request = null;
		if (request == null) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		}
		return request;
	}

	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;
	}

	/**
	 * 
	 * 方法: genUuid <br>
	 * 描述: 获取uuid <br>
	 * 作者: zhy<br>
	 * 时间: 2016年10月26日 下午9:45:41
	 * 
	 * @return
	 */
	public static String genUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
