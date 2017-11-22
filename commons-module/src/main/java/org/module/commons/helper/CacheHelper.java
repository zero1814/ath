package org.module.commons.helper;

import java.util.Map;

import org.module.cache.redis.RedisByte;
import org.module.cache.redis.RedisHash;
import org.module.cache.redis.RedisString;
import org.module.commons.BaseClass;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CacheHelper extends BaseClass {

	/**
	 * ====================String操作====================
	 */

	/**
	 * 
	 * 方法: setValue <br>
	 * 描述: 添加缓存 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:19:34
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(String key, String value) {
		new RedisString().setValue(key, value);
	}

	/**
	 * 
	 * 方法: setValue <br>
	 * 描述: 添加缓存 设置存储时间 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月6日 下午5:19:34
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(String key, String value, int seconds) {
		new RedisString().setValue(key, value, seconds);
	}

	/**
	 * 
	 * 方法: setValue <br>
	 * 描述: 添加缓存 设置存储时间 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月14日 上午9:33:40
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public static void setValue(byte[] key, byte[] value, int seconds) {
		new RedisByte().setValue(key, value, seconds);
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
	public static void updateValue(String key, String value) {
		new RedisString().updateValue(key, value);
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
	public static void delValue(String key) {
		new RedisString().delValue(key);
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
	public static String getValue(String key) {
		return new RedisString().getValue(key);
	}

	/**
	 * 
	 * 方法: getValue <br>
	 * 描述: 获取缓存值信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月14日 上午9:43:24
	 * 
	 * @param key
	 * @return
	 */
	public static byte[] getValue(byte[] key) {
		return new RedisByte().getValue(key);
	}

	/**
	 * ====================hash操作====================
	 */
	public static void setHash(String key, Map<String, String> hash) {
		new RedisHash().setHash(key, hash);
	}

	public static void setHash(byte[] key, Map<byte[], byte[]> hash) {
		new RedisHash().setHash(key, hash);
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
	public static Map<String, String> getHash(String key) {
		return new RedisHash().getHash(key);
	}

	public static Map<byte[], byte[]> getHash(byte[] key) {
		return new RedisHash().getHash(key);
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
	public static void setFiledVal(String key, String field, String value) {
		new RedisHash().setFiled(key, field, value);
	}

	public static void setFiledVal(byte[] key, byte[] field, byte[] value) {
		new RedisHash().setFiled(key, field, value);
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
	public static String getFiledVal(String key, String field) {
		return new RedisHash().getFiled(key, field);
	}

	public static byte[] getFiledVal(byte[] key, byte[] field) {
		return new RedisHash().getFiled(key, field);
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
	public static void delFiledVal(String key, String field) {
		new RedisHash().delFiled(key, field);
	}

	public static void delFiledVal(byte[] key, byte[] field) {
		new RedisHash().delFiled(key, field);
	}

	/**
	 * 
	 * 方法: getJSONObject <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月20日 下午7:18:31
	 * 
	 * @param key
	 * @return
	 */
	public static JSONObject getJSONObject(String key) {
		return new RedisString().getJSONObject(key);
	}

	/**
	 * 
	 * 方法: getJSONArray <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月20日 下午7:18:36
	 * 
	 * @param key
	 * @return
	 */
	public static JSONArray getJSONArray(String key) {
		return new RedisString().getJSONArray(key);
	}
}
