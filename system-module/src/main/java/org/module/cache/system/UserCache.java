package org.module.cache.system;

import java.util.Map;

import org.module.commons.annotation.Inject;
import org.module.helper.cache.CacheHashHelper;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.service.system.user.ISmUserService;

/**
 * 
 * 类: UserCache <br>
 * 描述: 获取缓存中的用户相关信息 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 上午10:08:44
 */
public class UserCache {

	@Inject
	private ISmUserService service;

	private static UserCache self;

	public static UserCache instance() {
		if (self == null) {
			self = new UserCache();
		}
		return self;
	}

	/**
	 * 
	 * 方法: getUser <br>
	 * 描述: 获取user信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月18日 下午2:53:42
	 * 
	 * @return
	 */
	public SmUser getUser() {
		Map<String, String> userCache = CacheHashHelper.instance().getHash("122312");
		/**
		 * 读取缓存，如果缓存数据为空，访问数据库查询数据
		 */
		if (userCache == null) {
			SmUser entity = new SmUser();
			entity.setUserName("12");
			entity.setPassword("123");
			EntityResult result = service.selectByEntity(entity);
			if (result.getCode() == 0) {
			}
		}
		return null;
	}
}
