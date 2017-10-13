package org.module.cache;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RedisString <br>
 * 描述: redis对字符串操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月5日 下午4:21:05
 */
public class CacheString extends BaseClass {

	@Inject
	private JedisCluster jedisCluster;

	private static CacheString self;

	public static CacheString instance() {
		if (self == null) {
			self = new CacheString();
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
		if (jedisCluster.exists(key)) {
			jedisCluster.del(key);
		}
		jedisCluster.set(key, value);
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
		if (jedisCluster.exists(key)) {
			jedisCluster.del(key);
		}
		jedisCluster.set(key, value);
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
		if (jedisCluster.exists(key)) {
			return jedisCluster.get(key);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 方法: getJSONObject <br>
	 * 描述: 获取json对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 上午11:04:37
	 * 
	 * @param key
	 * @return
	 */
	public JSONObject getJSONObject(String key) {
		if (jedisCluster.exists(key)) {
			JSONObject obj = JSONObject.parseObject(jedisCluster.get(key));
			return obj;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 方法: getJSONArray <br>
	 * 描述: 获取json数组对象 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 上午11:04:46
	 * 
	 * @param key
	 * @return
	 */
	public JSONArray getJSONArray(String key) {
		if (jedisCluster.exists(key)) {
			JSONArray obj = JSONArray.parseArray(jedisCluster.get(key));
			return obj;
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
		if (jedisCluster.exists(key)) {
			jedisCluster.del(key);
		}
	}

}
