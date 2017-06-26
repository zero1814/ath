package org.module.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.module.cache.RedisString;
import org.module.model.system.user.SmUser;
import org.module.system.util.Constant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserHelper {

	private HttpServletRequest request;

	private static UserHelper self;

	public static UserHelper intance() {
		if (self == null) {
			self = new UserHelper();
		}
		return self;
	}

	public SmUser userInfo() {
		SmUser user = new SmUser();
		HttpServletRequest request = getRequest();
		if (request != null) {
			HttpSession session = this.getRequest().getSession();
			if (session != null) {
				String key = session.getAttribute(Constant.SESSION_USER).toString();
				if (key != null) {
					JSONObject obj = RedisString.instance().getJSONObject(key);
					if (obj != null) {
						user = JSON.toJavaObject(obj, SmUser.class);
					}
				}
			}
		}
		return user;
	}

	/**
	 * 
	 * 方法: getRequest <br>
	 * 描述: 获取request <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 上午10:02:29
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		if (request == null) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		}
		return request;
	}

}
