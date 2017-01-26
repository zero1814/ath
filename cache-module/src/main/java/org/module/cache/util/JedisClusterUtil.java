package org.module.cache.util;

import com.google.inject.Inject;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: JedisClusterUtil <br>
 * 描述: jedis:redis集群操作类 <br>
 * 作者: zhy<br>
 * 时间: 2017年1月26日 上午7:58:16
 */
public class JedisClusterUtil {

	@Inject
	private JedisCluster cluster;
	
	public int save(){
		return 0;
	}
}
