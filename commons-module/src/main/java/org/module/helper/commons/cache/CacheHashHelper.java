package org.module.helper.commons.cache;

import java.util.Map;

import org.module.annotation.Inject;
import org.module.base.BaseClass;

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
	 * ==============string操作==============
	 */
	
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
	 * ====================hash操作====================
	 */
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
}
