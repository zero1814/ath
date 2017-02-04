package org.module.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-redis.xml" })
public class RedisTest {

	@Autowired
	private JedisCluster cluster;

	@Test
	public void addValue() {
		String value = cluster.set("add", "value");
		System.out.println(value);
	}
}
