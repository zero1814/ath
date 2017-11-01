package org.module.cache.commons;

import java.util.Map;

import org.module.annotation.Inject;
import org.module.base.BaseClass;

import redis.clients.jedis.JedisCluster;

public class RedisHash extends BaseClass {
	@Inject
	private JedisCluster cluster;

	public void setHash(String key, Map<String, String> hash) {
		if (cluster != null) {
			if (cluster.exists(key)) {
				cluster.del(key);
			}
			cluster.hmset(key, hash);
		}
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
		if (cluster != null) {
			return cluster.hgetAll(key);
		} else {
			return null;
		}
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
		if (cluster != null) {
			if (cluster.hexists(key, field)) {
				cluster.hdel(key, field);
			}
			cluster.hset(key, field, value);
		}
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
		String value = "";
		if (cluster != null) {
			value = cluster.hget(key, field);
		}
		return value;
	}

	/**
	 * 
	 * 方法: delFiled <br>
	 * 描述: 删除集合属性 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月20日 下午7:16:17
	 * 
	 * @param key
	 * @param filed
	 */
	public void delFiled(String key, String field) {
		if (cluster != null) {
			cluster.hdel(key, field);
		}
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
		if (cluster != null) {
			cluster.del(key);
		}
	}

}
