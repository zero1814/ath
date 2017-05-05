package org.module.cache;

import org.module.commons.annotation.Inject;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RedisString <br>
 * 描述: redis对字符串操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月5日 下午4:21:05
 */
public class RedisString {

	@Inject
	private JedisCluster cluster;

	private static RedisString self;

	public static RedisString instance() {
		if (self == null) {
			self = new RedisString();
		}
		return self;
	}

	/**
	 * 
	 * 方法: setValue <br>
	 * 描述: 存储值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午4:21:02
	 * 
	 * @param key
	 * @param value
	 */
	public void setValue(String key, String value) {
		if (cluster.exists(key)) {
			cluster.getSet(key, value);
		} else {
			cluster.set(key, value);
		}

	}

	/**
	 * 
	 * 方法: updateValue <br>
	 * 描述: 根据key修改存储值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午4:24:46
	 * 
	 * @param key
	 * @param value
	 */
	public void updateValue(String key, String value) {
		if (cluster.exists(key)) {
			cluster.getSet(key, value);
		}
	}

	/**
	 * 
	 * 方法: getValue <br>
	 * 描述: 获取存储值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午4:22:16
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		if (cluster.exists(key)) {
			return cluster.get(key);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 方法: delValue <br>
	 * 描述: 删除操作 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月5日 下午4:22:33
	 * 
	 * @param key
	 */
	public void delValue(String key) {
		if (cluster.exists(key)) {
			cluster.del(key);
		}
	}

}
