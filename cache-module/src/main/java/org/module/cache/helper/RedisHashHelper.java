package org.module.cache.helper;

import java.util.List;
import java.util.Map;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;

import redis.clients.jedis.JedisCluster;

public class RedisHashHelper extends BaseClass {

	@Inject
	private JedisCluster cluster;

	/**
	 * 
	 * 方法: hset <br>
	 * 描述: 将哈希表key中的域field的值设为value。<br>
	 * 如果key不存在，一个新的哈希表被创建并进行HSET操作。<br>
	 * 如果域field已经存在于哈希表中，旧值将被覆盖。<br>
	 * 
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:20:51
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	public void hset(String key, String field, String value) {
		cluster.hset(key, field, value);
	}

	/**
	 * 
	 * 方法: hsetnx <br>
	 * 描述: 将哈希表key中的域field的值设置为value，当且仅当域field不存在。<br>
	 * 若域field已经存在，该操作无效。<br>
	 * 如果key不存在，一个新哈希表被创建并执行HSETNX命令。<br>
	 * 
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:21:43
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	public void hsetnx(String key, String field, String value) {
		cluster.hsetnx(key, field, value);
	}

	/**
	 * 
	 * 方法: hmset <br>
	 * 描述: 同时将多个field - value(域-值)对设置到哈希表key中。<br>
	 * 此命令会覆盖哈希表中已存在的域。<br>
	 * 如果key不存在，一个空哈希表被创建并执行HMSET操作。<br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:23:26
	 * 
	 * @param key
	 * @param param
	 */
	public void hmset(String key, Map<String, String> param) {
		cluster.hmset(key, param);
	}

	/**
	 * 
	 * 方法: hget <br>
	 * 描述: 返回哈希表key中给定域field的值。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:24:35
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public String hget(String key, String field) {
		return cluster.hget(key, field);
	}

	/**
	 * 
	 * 方法: hmget <br>
	 * 描述: 返回哈希表key中，一个或多个给定域的值。<br>
	 * 如果给定的域不存在于哈希表，那么返回一个nil值。<br>
	 * 因为不存在的key被当作一个空哈希表来处理，所以对一个不存在的key进行HMGET操作将返回一个只带有nil值的表 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:25:46
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public List<String> hmget(String key, String... fields) {
		return cluster.hmget(key, fields);
	}

	/**
	 * 
	 * 方法: hdel <br>
	 * 描述: 删除哈希表key中的一个指定域，不存在的域将被忽略。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:32:36
	 * 
	 * @param key
	 * @param field
	 */
	public void hdel(String key, String field) {
		cluster.hdel(key, field);
	}

	/**
	 * 
	 * 方法: hdel <br>
	 * 描述: 删除哈希表key中的多个指定域，不存在的域将被忽略。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:33:42
	 * 
	 * @param key
	 * @param fields
	 */
	public void hdel(String key, String... fields) {
		cluster.hdel(key, fields);
	}
}
