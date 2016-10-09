package org.module.commons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring.redis.xml" })
public class RedisTest {

	@Autowired
	private JedisPool pool;

	@Test
	public void conn() {
		Jedis jedis = pool.getResource();
		if (jedis != null) {
			jedis.set("address", "测试数据");
		} else {
			System.out.println("jedis为空");
		}
	}
}
