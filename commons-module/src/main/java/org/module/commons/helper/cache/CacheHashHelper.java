package org.module.commons.helper.cache;

import java.util.Map;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;


import redis.clients.jedis.JedisCluster;

public class CacheHashHelper extends BaseClass {

	@Inject
	private JedisCluster cluster;

	private static CacheHashHelper self;

	public static CacheHashHelper instance() {
		if (self == null) {
			self = new CacheHashHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: addCache <br>
	 * 描述: 添加缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:21:27
	 * 
	 * @param key
	 * @param hash
	 */
	public void addCache(String key, Map<String, String> hash) {
		cluster.hmset(key, hash);
	}

	/**
	 * 
	 * 方法: editCache <br>
	 * 描述: 编辑缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:36:45
	 * 
	 * @param key
	 * @param hash
	 */
	public void editCache(String key, Map<String, String> hash) {
		if (cluster.exists(key)) {
			cluster.del(key);
		}
		cluster.hmset(key, hash);
	}

	/**
	 * 
	 * 方法: delCache <br>
	 * 描述: 删除缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:37:12
	 * 
	 * @param key
	 */
	public void delCache(String key) {
		cluster.del(key);
	}

	/**
	 * 
	 * 方法: delCache <br>
	 * 描述: 删除缓存hash指定值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 上午8:40:13
	 * 
	 * @param key
	 * @param field
	 */
	public void delCache(String key, String... field) {
		cluster.hdel(key, field);
	}

	/**
	 * 
	 * 方法: getCacheValue <br>
	 * 描述: 获取缓存值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:44:56
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public String getCacheValue(String key, String field) {
		String val = "";
		if (cluster.hexists(key, field)) {
			val = cluster.hget(key, field);
		}
		return val;
	}

	/**
	 * 
	 * 方法: getCacheHash <br>
	 * 描述: 获取hash缓存信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:47:02
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getCacheHash(String key) {
		Map<String, String> map = null;
		if (cluster.exists(key)) {
			map = cluster.hgetAll(key);
		}
		return map;
	}
}
