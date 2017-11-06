package org.module.system.factory;

import javax.servlet.http.HttpSession;

import org.module.base.BaseClass;
import org.module.cache.system.CacheKey;
import org.module.helper.CacheHelper;
import org.module.helper.WebHelper;
import org.module.model.system.user.SmUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserFactory extends BaseClass {

	/**
	 * 
	 * 方法: userInfo <br>
	 * 描述: 获取session用户信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月11日 下午2:32:16
	 * 
	 * @return
	 */
	public static SmUser userInfo() {
		SmUser user = null;
		HttpSession session = WebHelper.getSession();
		if (session != null) {
			String key = CacheKey.SESSION_USER_KEY + session.getId();
			if (key != null) {
				JSONObject obj = CacheHelper.getJSONObject(key);
				if (obj != null) {
					user = JSON.toJavaObject(obj, SmUser.class);
				}
			}
		}
		return user;
	}
}
