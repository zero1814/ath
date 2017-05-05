package org.module.commons;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-redis.xml" })
public class RedisTest {

	@Autowired
	private JedisCluster cluster;
	@Autowired
	private JedisPool pool;

	public void jedis() {
		Jedis jedis = new Jedis("172.21.0.52", 7000);
		jedis.set("add", "add");
		System.out.println(jedis.get("add"));
		
	}
	
	@Test
	public void cluster(){
		cluster.set("add", "add");
		System.out.println(cluster.get("add"));
	}

	public void socketTest() {
		String host = "172.21.0.52";
		int port = 6379;
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
