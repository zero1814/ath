package org.module.helper;

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
	 * ====================String操作====================
	 */

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
	public void setValue(String key, String value) {
		cluster.set(key, value);
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
	public void updateValue(String key, String value) {
		if (cluster.exists(key)) {
			cluster.del(key);
		}
		cluster.set(key, value);
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
	public void delValue(String key) {
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
	public String getValue(String key) {
		String value = "";
		if (cluster.exists(key)) {
			value = cluster.get(key);
		}
		return value;
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
	public void setFiledVal(String key, String field, String value) {
		if (cluster.hexists(key, field)) {
			cluster.hdel(key, field);
		}
		cluster.hset(key, field, value);
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
	public void updateFiledVal(String key, String value) {
		if (cluster.exists(key)) {
			cluster.getSet(key, value);
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
	public String getFiledVal(String key, String field) {
		return cluster.hget(key, field);
	}

	/**
	 * 
	 * 方法: delFiledVal <br>
	 * 描述: 删除field的value值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月19日 下午1:59:21
	 * 
	 * @param key
	 * @param field
	 */
	public void delFiledVal(String key, String field) {
		if (cluster.hexists(key, field)) {
			cluster.hdel(key, field);
		}
	}
}
