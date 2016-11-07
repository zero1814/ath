package org.module.cache.helper;

import java.util.List;

import org.module.commons.annotation.Inject;

import redis.clients.jedis.JedisCluster;

public class RedisStringHelper implements BaseHelper {
	@Inject
	private JedisCluster cluster;

	private static RedisStringHelper self;

	public static RedisStringHelper instance() {
		if (self == null) {
			self = new RedisStringHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: set <br>
	 * 描述: 将字符串值value关联到key。<br>
	 * 如果key已经持有其他值，SET就覆写旧值，无视类型。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:09:41
	 * 
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
		cluster.set(key, value);
	}

	/**
	 * 
	 * 方法: setnx <br>
	 * 描述: 将key的值设为value，当且仅当key不存在。<br>
	 * 若给定的key已经存在，则SETNX不做任何动作。<br>
	 * SETNX是”SET if Not eXists”(如果不存在，则SET)的简写。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:10:42
	 * 
	 * @param key
	 * @param value
	 */
	public void setnx(String key, String value) {
		cluster.setnx(key, value);
	}

	/**
	 * 
	 * 方法: setex <br>
	 * 描述: 将值value关联到key，并将key的生存时间设为seconds(以秒为单位) <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:13:35
	 * 
	 * @param key
	 * @param value
	 * @param liveSeconds
	 */
	public void setex(String key, String value, Integer liveSeconds) {
		cluster.setex(key, liveSeconds, value);
	}

	/**
	 * 
	 * 方法: mset <br>
	 * 描述: 同时设置一个或多个key-value对。<br>
	 * 当发现同名的key存在时，MSET会用新值覆盖旧值，如果你不希望覆盖同名key，请使用MSETNX命令。<br>
	 * MSET是一个原子性(atomic)操作，所有给定key都在同一时间内被设置，<br>
	 * 某些给定key被更新而另一些给定key没有改变的情况，不可能发生。<br>
	 * 
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:17:47
	 * 
	 * @param param
	 */
	public void mset(String... param) {
		cluster.mset(param);
	}

	/**
	 * 
	 * 方法: msetnx <br>
	 * 描述: 同时设置一个或多个key-value对，当且仅当key不存在。<br>
	 * 即使只有一个key已存在，MSETNX也会拒绝所有传入key的设置操作<br>
	 * MSETNX是原子性的，因此它可以用作设置多个不同key表示不同字段(field)的唯一性逻辑对象(unique logic object)，
	 * <br>
	 * 所有字段要么全被设置，要么全不被设置。<br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:19:22
	 * 
	 * @param param
	 */
	public void msetnx(String... param) {
		cluster.msetnx(param);
	}

	/**
	 * 
	 * 方法: get <br>
	 * 描述: 返回key所关联的字符串值。<br>
	 * 如果key不存在则返回特殊值nil。<br>
	 * 假如key储存的值不是字符串类型，返回一个错误，因为GET只能用于处理字符串值。<br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:15:01
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return cluster.get(key);
	}

	/**
	 * 
	 * 方法: mget <br>
	 * 描述: 返回所有(一个或多个)给定key的值。<br>
	 * 如果某个指定key不存在，那么返回特殊值nil。因此，该命令永不失败。<br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:16:41
	 * 
	 * @param keys
	 * @return
	 */
	public List<String> mget(String... keys) {
		return cluster.mget(keys);
	}

	/**
	 * 
	 * 方法: del <br>
	 * 描述: 移除给定的一个key，如果key不存在，则忽略该命令。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:30:17
	 * 
	 * @param key
	 */
	public void del(String key) {
		cluster.del(key);
	}

	/**
	 * 
	 * 方法: del <br>
	 * 描述: 移除给定的多个key，如果key不存在，则忽略该命令。 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:29:30
	 * 
	 * @param keys
	 */
	public void del(String... keys) {
		cluster.del(keys);
	}
}
