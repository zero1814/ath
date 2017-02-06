package org.module.commons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-redis.xml" })
public class RedisTest {

	@Autowired
	private JedisCluster cluster;

	@Test
	public void conn() {
		// JedisPool pool = new JedisPool("172.21.0.31", 6379);
		// try {
		// Jedis jedis = pool.getResource();
		// jedis.set("add", "value");
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// pool.close();
		// }
		cluster.set("add", "value");
	}
}
