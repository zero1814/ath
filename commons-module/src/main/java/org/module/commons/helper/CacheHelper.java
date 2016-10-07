package org.module.commons.helper;

import org.module.commons.base.BaseClass;
import org.module.commons.util.RedisUtil;

/**
 * 
 * 类: CacheHelper <br>
 * 描述: 缓存帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月24日 下午3:56:16
 */
public class CacheHelper extends BaseClass {

	private static CacheHelper self;

	public static CacheHelper instance() {
		if (self != null) {
			self = new CacheHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: setValue <br>
	 * 描述: 存储key-value值到缓存数据库 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月24日 下午4:42:13
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String setValue(String key, String value) {
		return RedisUtil.instance().setValue(key, value);
	}
}
