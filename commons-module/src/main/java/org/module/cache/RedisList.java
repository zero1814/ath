package org.module.cache;


import org.module.commons.annotation.Inject;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: RedisList <br>
 * 描述: list集合redis处理 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月5日 下午5:11:27
 */
public class RedisList {

	@Inject
	private JedisCluster cluster;

	private static RedisList self;

	public static RedisList instance() {
		if (self == null) {
			self = new RedisList();
		}
		return self;
	}
	
	public void set(String key,String... values){
		cluster.lpush(key, values);
	}

}
