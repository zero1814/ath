package org.module.commons.helper.cache;

import java.util.Map;

import org.module.commons.base.BaseClass;

import com.google.inject.Inject;

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
	 * 方法: addCacheByHash <br>
	 * 描述: 存储hash <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:21:27
	 * 
	 * @param key
	 * @param hash
	 */
	public void addCacheByHash(String key, Map<String, String> hash) {
		cluster.hmset(key, hash);
	}
}
