package org.module.cache.helper;

import org.module.cache.enumer.Redis;
import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RedisHelper <br>
 * 描述: 缓存帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2016年11月7日 下午9:51:21
 */
public class RedisHelper extends BaseClass {

	@Inject
	private JedisCluster cluster;

	public BaseHelper helper;

	public BaseHelper instance(Redis type) {
		if (helper == null) {
			if (type == Redis.String) {
				helper = new RedisStringHelper();
			} else if (type == Redis.Hash) {
				helper = new RedisHashHelper();
			} else if (type == Redis.List) {
				helper = new RedisListHelper();
			}
		}
		return helper;
	}
}
