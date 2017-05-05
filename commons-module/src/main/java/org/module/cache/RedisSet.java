package org.module.cache;

import org.module.commons.annotation.Inject;

import redis.clients.jedis.JedisCluster;

public class RedisSet {

	@Inject
	private JedisCluster cluster;
}
