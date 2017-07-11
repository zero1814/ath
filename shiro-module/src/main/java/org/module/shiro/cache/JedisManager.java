package org.module.shiro.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.module.logger.LoggerHelper;
import org.module.util.SerializeUtil;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 类: JedisManager <br>
 * 描述: Redis Manager Utils <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:25:00
 */
public class JedisManager {

	public static final String SESSION = "ath-cms-session";
	private JedisCluster jedisCluster;

	public byte[] getValueByKey(byte[] key) throws Exception {
		byte[] result = null;
		try {
			result = jedisCluster.hget(SESSION.getBytes(), key);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public void deleteByKey(byte[] key) throws Exception {
		try {
			Long result = jedisCluster.hdel(SESSION.getBytes(), key);
			LoggerHelper.debug(getClass(), "删除Session结果：" + result);
		} catch (Exception e) {
			throw e;
		}
	}

	public void saveValueByKey(byte[] key, byte[] value, int expireTime) throws Exception {
		try {
			jedisCluster.hset(SESSION.getBytes(), key, value);
			if (expireTime > 0)
				jedisCluster.expire(key, expireTime);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * 方法: AllSession <br>
	 * 描述: 获取所有Session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月3日 上午10:25:37
	 * 
	 * @param dbIndex
	 * @param redisShiroSession
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<Session> AllSession(String redisShiroSession) throws Exception {
		Set<Session> sessions = new HashSet<Session>();
		try {
			Set<byte[]> byteKeys = jedisCluster.hkeys(SESSION.getBytes());
			if (byteKeys != null && byteKeys.size() > 0) {
				for (byte[] bs : byteKeys) {
					Session obj = SerializeUtil.deserialize(jedisCluster.hget(SESSION.getBytes(), bs), Session.class);
					if (obj instanceof Session) {
						sessions.add(obj);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return sessions;
	}

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}
	
}
