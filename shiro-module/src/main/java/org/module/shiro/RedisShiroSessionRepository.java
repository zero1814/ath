package org.module.shiro;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.module.commons.annotation.Inject;
import org.module.commons.util.SerializeUtil;
import org.module.helper.commons.LogHelper;
import org.module.shiro.session.ShiroSessionRepository;

import redis.clients.jedis.JedisCluster;

public class RedisShiroSessionRepository implements ShiroSessionRepository {
	public static final String REDIS_SHIRO_SESSION = "ath-shiro-session-";
	// 这里有个小BUG，因为Redis使用序列化后，Key反序列化回来发现前面有一段乱码，解决的办法是存储缓存不序列化
	public static final String REDIS_SHIRO_ALL = "*ath-shiro-session-*";
	// 存储时间
	private static final int SESSION_VAL_TIME_SPAN = 18000;

	@Inject
	private JedisCluster cluster;

	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null)
			throw new NullPointerException("session is empty");
		try {
			byte[] key = SerializeUtil.serialize(REDIS_SHIRO_SESSION + session.getId());
			byte[] value = SerializeUtil.serialize(session);
			long sessionTimeOut = session.getTimeout() / 1000;
			Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
			cluster.set(key, value, null, null, expireTime);
		} catch (Exception e) {
			LogHelper.error(RedisShiroSessionRepository.class, "save session error，id:" + session.getId());
		}
	}

	@Override
	public void deleteSession(Serializable sessionId) {
		byte[] key = SerializeUtil.serialize(REDIS_SHIRO_SESSION + sessionId);
		if (cluster.exists(key)) {
			cluster.del(key);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Session getSession(Serializable sessionId) {
		byte[] key = SerializeUtil.serialize(REDIS_SHIRO_SESSION + sessionId);
		if (cluster.exists(key)) {
			byte[] val = cluster.get(key);
			return SerializeUtil.deserialize(val, Session.class);
		} else {
			return null;
		}
	}

	@Override
	public Collection<Session> getAllSessions() {
		return null;
	}

}
