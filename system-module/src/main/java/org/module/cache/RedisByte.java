package org.module.cache;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;

import redis.clients.jedis.JedisCluster;

public class RedisByte extends BaseClass {
	@Inject
	private JedisCluster cluster;

	private static RedisByte self;

	public static RedisByte instance() {
		if (self == null) {
			self = new RedisByte();
		}
		return self;
	}

	public byte[] getValue(byte[] key) {
		if (cluster.exists(key)) {
			return cluster.get(key);
		} else {
			return null;
		}
	}

	public void setValue(byte[] key, byte[] value) {
		if (cluster.exists(key)) {
			cluster.del(key);
		}
		cluster.set(key, value);
	}

	public void delValue(byte[] key) {
		cluster.del(key);
	}
}
