package org.module.cache.commons;

import org.module.annotation.Inject;

import redis.clients.jedis.JedisCluster;

public class RedisByte {
	@Inject
	private JedisCluster cluster;

	public void setValue(byte[] key, byte[] value) {
		cluster.set(key, value);
	}

	public void setValue(byte[] key, byte[] value, int seconds) {
		cluster.setbit(key, seconds, value);
	}

	public byte[] getValue(byte[] key) {
		if (cluster.exists(key)) {
			return cluster.get(key);
		} else {
			return null;
		}
	}
	
	
}
