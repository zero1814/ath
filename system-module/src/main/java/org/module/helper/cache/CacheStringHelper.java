package org.module.helper.cache;

import org.module.annotation.Inject;

import redis.clients.jedis.JedisCluster;

public class CacheStringHelper {

	@Inject
	private JedisCluster cluster;

	private static CacheStringHelper self;

	public static CacheStringHelper instance() {
		if (self == null) {
			self = new CacheStringHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: addCache <br>
	 * 描述: 添加缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:19:34
	 * 
	 * @param key
	 * @param value
	 */
	public void addCache(String key, String value) {
		cluster.set(key, value);
		cluster.sadd(key, value);
	}

	/**
	 * 
	 * 方法: editValue <br>
	 * 描述: 编辑缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:19:48
	 * 
	 * @param key
	 * @param value
	 */
	public void editCache(String key, String value) {
		if (cluster.exists(key)) {
			cluster.del(key);
		}
		cluster.sadd(key, value);
	}

	/**
	 * 
	 * 方法: delCache <br>
	 * 描述: 删除缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:20:22
	 * 
	 * @param key
	 */
	public void delCache(String key) {
		cluster.del(key);
	}

	/**
	 * 
	 * 方法: getCacheValue <br>
	 * 描述: 获取缓存值信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:45:53
	 * 
	 * @param key
	 * @return
	 */
	public String getCacheValue(String key) {
		String value = "";
		if (cluster.exists(key)) {
			value = cluster.get(key);
		}
		return value;
	}

}
