package org.module.cache.helper;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;

import redis.clients.jedis.JedisCluster;

public class RedisHelper extends BaseClass {

	@Inject
	private JedisCluster cluster;

	private static RedisHelper self;

	public static RedisHelper instance() {
		if (self == null) {
			self = new RedisHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: getValue <br>
	 * 描述: 根据key值获取redis缓存的value值 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月22日 下午10:15:10
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return cluster.get(key);
	}

	/**
	 * 
	 * 方法: setValue <br>
	 * 描述: 存储key-value到redis缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月22日 下午10:18:19
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String setValue(String key, String value) {
		return cluster.set(key, value);
	}
}
