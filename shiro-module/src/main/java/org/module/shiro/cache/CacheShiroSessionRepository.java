package org.module.shiro.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.module.helper.CacheHelper;
import org.module.helper.LoggerHelper;
import org.module.shiro.session.CustomSessionManager;
import org.module.shiro.session.SessionStatus;
import org.module.shiro.session.ShiroSessionRepository;
import org.module.util.SerializeUtil;

/**
 * 
 * 类: CacheShiroSessionRepository <br>
 * 描述: session缓存 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月14日 上午9:24:02
 */
public class CacheShiroSessionRepository implements ShiroSessionRepository {

	private static final String REDIS_SHIRO_SESSION = "shiro-session";

	/**
	 * 
	 * 方法: saveSession <br>
	 * 描述: 保存session
	 * 
	 * @param session
	 * @see org.module.shiro.session.ShiroSessionRepository#saveSession(org.apache.shiro.session.Session)
	 */
	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null)
			throw new NullPointerException("session is empty");
		try {
			byte[] key = buildKey();
			byte[] filed = buildFiled(session.getId());
			// 不存在才添加。
			if (null == session.getAttribute(CustomSessionManager.SESSION_STATUS)) {
				// Session 踢出自存存储。
				SessionStatus sessionStatus = new SessionStatus();
				session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
			}
			byte[] value = SerializeUtil.serialize(session);
			CacheHelper.setFiledVal(key, filed, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 方法: deleteSession <br>
	 * 描述: 删除session
	 * 
	 * @param sessionId
	 * @see org.module.shiro.session.ShiroSessionRepository#deleteSession(java.io.Serializable)
	 */
	@Override
	public void deleteSession(Serializable sessionId) {
		if (sessionId == null) {
			throw new NullPointerException("session id is empty");
		}
		try {
			byte[] field = buildFiled(sessionId);
			CacheHelper.delFiledVal(buildKey(), field);
		} catch (Exception e) {
			LoggerHelper.error(getClass(), "删除session出现异常，id:[%s]", sessionId);
		}
	}

	/**
	 * 
	 * 方法: getSession <br>
	 * 描述: 获取session
	 * 
	 * @param sessionId
	 * @return
	 * @see org.module.shiro.session.ShiroSessionRepository#getSession(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Session getSession(Serializable sessionId) {
		if (sessionId == null)
			throw new NullPointerException("session id is empty");
		Session session = null;
		try {
			byte[] key = buildKey();
			byte[] field = buildFiled(sessionId);
			byte[] value = CacheHelper.getFiledVal(key, field);
			session = SerializeUtil.deserialize(value, Session.class);
		} catch (Exception e) {
			LoggerHelper.error(getClass(), "获取session异常，id:[%s]", sessionId);
		}
		return session;
	}

	/**
	 * 
	 * 方法: getAllSessions <br>
	 * 描述: 获取所有session
	 * 
	 * @return
	 * @see org.module.shiro.session.ShiroSessionRepository#getAllSessions()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Session> getAllSessions() {
		Set<Session> sessions = new HashSet<Session>();
		try {
			byte[] key = buildKey();
			Map<byte[], byte[]> map = CacheHelper.getHash(key);
			Set<byte[]> keys = map.keySet();
			if (keys != null && keys.size() > 0) {
				for (byte[] bs : keys) {
					Session obj = SerializeUtil.deserialize(map.get(bs), Session.class);
					if (obj instanceof Session) {
						sessions.add(obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerHelper.error(getClass(), "获取全部session异常");
		}
		return sessions;
	}

	private byte[] buildKey() {
		return SerializeUtil.serialize(REDIS_SHIRO_SESSION);
	}

	private byte[] buildFiled(Serializable sessionId) {
		String filed = REDIS_SHIRO_SESSION + sessionId;
		return SerializeUtil.serialize(filed);
	}
}
