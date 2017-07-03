package org.module.shiro.cache;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.module.commons.util.SerializeUtil;
import org.module.helper.commons.LoggerHelper;
import org.module.shiro.session.CustomSessionManager;
import org.module.shiro.session.SessionStatus;
import org.module.shiro.session.ShiroSessionRepository;

/**
 * 
 * 类: JedisShiroSessionRepository <br>
 * 描述: Session 管理 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:25:55
 */
@SuppressWarnings("unchecked")
public class JedisShiroSessionRepository implements ShiroSessionRepository {
	public static final String REDIS_SHIRO_SESSION = "ath-cms-session";
	// 这里有个小BUG，因为Redis使用序列化后，Key反序列化回来发现前面有一段乱码，解决的办法是存储缓存不序列化
	public static final String REDIS_SHIRO_ALL = "*ath-cms-session*";
	private static final int SESSION_VAL_TIME_SPAN = 18000;

	private JedisManager jedisManager;

	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null)
			throw new NullPointerException("session is empty");
		try {
			byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session.getId()));

			// 不存在才添加。
			if (null == session.getAttribute(CustomSessionManager.SESSION_STATUS)) {
				// Session 踢出自存存储。
				SessionStatus sessionStatus = new SessionStatus();
				session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
			}

			byte[] value = SerializeUtil.serialize(session);
			long sessionTimeOut = session.getTimeout() / 1000;
			Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
			getJedisManager().saveValueByKey(key, value, expireTime.intValue());
		} catch (Exception e) {
			LoggerHelper.error(getClass(), "save session error，id:" + session.getId());
		}
	}

	@Override
	public void deleteSession(Serializable id) {
		if (id == null) {
			throw new NullPointerException("session id is empty");
		}
		try {
			getJedisManager().deleteByKey(SerializeUtil.serialize(buildRedisSessionKey(id)));
		} catch (Exception e) {
			LoggerHelper.error(getClass(), "删除session出现异常，id:" + id);
		}
	}

	@Override
	public Session getSession(Serializable id) {
		if (id == null)
			throw new NullPointerException("session id is empty");
		Session session = null;
		try {
			byte[] value = getJedisManager().getValueByKey(SerializeUtil.serialize(buildRedisSessionKey(id)));
			session = SerializeUtil.deserialize(value, Session.class);
		} catch (Exception e) {
			LoggerHelper.error(getClass(), "获取session异常，id:" + id);
		}
		return session;
	}

	@Override
	public Collection<Session> getAllSessions() {
		Collection<Session> sessions = null;
		try {
			sessions = getJedisManager().AllSession(REDIS_SHIRO_SESSION);
		} catch (Exception e) {
			LoggerHelper.error(getClass(), "获取全部session异常");
		}

		return sessions;
	}

	private String buildRedisSessionKey(Serializable sessionId) {
		return REDIS_SHIRO_SESSION + sessionId;
	}

	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}
}
