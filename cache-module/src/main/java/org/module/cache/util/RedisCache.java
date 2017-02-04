package org.module.cache.util;

import org.module.commons.base.BaseClass;
import org.springframework.stereotype.Component;

import com.google.inject.Inject;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RootCache <br>
 * 描述: redis缓存相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月4日 上午9:27:02
 */
@Component
public class RedisCache extends BaseClass {

	@Inject
	private JedisCluster cluster;

	public void addValue(String key, String value) {
		String result = cluster.set(key, value);
		System.out.println(result);
	}
}
