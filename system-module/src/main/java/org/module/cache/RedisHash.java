package org.module.cache;

import java.util.Map;

import org.module.annotation.Inject;
import org.module.base.BaseClass;

import redis.clients.jedis.JedisCluster;

public class RedisHash extends BaseClass {
	@Inject
	private JedisCluster cluster;

	private static RedisHash self;

	public static RedisHash instance() {
		if (self == null) {
			self = new RedisHash();
		}
		return self;
	}

	public void setHash(String key, Map<String, String> hash) {
		if (cluster.exists(key)) {
			cluster.del(key);
		}
		cluster.hmset(key, hash);
	}

	/**
	 * 
	 * 方法: get <br>
	 * 描述: 获取hash集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午5:02:31
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getHash(String key) {
		return cluster.hgetAll(key);
	}

	/**
	 * 
	 * 方法: setFiled <br>
	 * 描述: hash存储filed值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午5:09:54
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	public void setFiled(String key, String field, String value) {
		if (cluster.hexists(key, field)) {
			cluster.hdel(key, field);
		}
		cluster.hset(key, field, value);
	}

	/**
	 * 
	 * 方法: getFiled <br>
	 * 描述: 获取field的value值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午5:02:14
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public String getFiled(String key, String field) {
		return cluster.hget(key, field);
	}

	/**
	 * 
	 * 方法: del <br>
	 * 描述: 删除 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午5:02:05
	 * 
	 * @param key
	 * @return
	 */
	public void del(String key) {
		cluster.del(key);
	}

}
