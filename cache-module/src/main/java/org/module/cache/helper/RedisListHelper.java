package org.module.cache.helper;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;

import redis.clients.jedis.JedisCluster;

public class RedisListHelper extends BaseClass {

	@Inject
	private JedisCluster cluster;

	/**
	 * 
	 * 方法: lpush <br>
	 * 描述: 将值value插入到列表key的表头。 <br>
	 * 如果key不存在，一个空列表会被创建并执行LPUSH操作。 当key存在但不是列表类型时，返回一个错误。 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:35:28
	 * 
	 * @param values
	 */
	public void lpush(String key, String... values) {
		cluster.lpush(key, values);
	}

	/**
	 * 
	 * 方法: lpushx <br>
	 * 描述: 将值value插入到列表key的表头，当且仅当key存在并且是一个列表。 <br>
	 * 和LPUSH命令相反，当key不存在时，LPUSHX命令什么也不做。<br>
	 * 
	 * 作者: zhy<br>
	 * 时间: 2016年11月7日 下午10:41:37
	 * 
	 * @param key
	 * @param values
	 */
	public void lpushx(String key, String... values) {
		cluster.lpushx(key, values);
	}
}
