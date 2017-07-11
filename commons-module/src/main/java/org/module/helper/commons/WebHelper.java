package org.module.helper.commons;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
			LoggerBaseHelper.error(WebHelper.class, "获取ip地址报错，错误原因:" + e.getMessage());
			e.printStackTrace();
		}
		return ip;
	}
}
