package org.module.shiro.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.module.helper.commons.LogHelper;
import org.module.shiro.RedisShiroSessionRepository;

/**
 * 
 * 类: CustomShiroSessionDAO <br>
 * 描述: Session 操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月28日 下午1:46:00
 */
public class CustomShiroSessionDAO extends AbstractSessionDAO {

	private RedisShiroSessionRepository repository;

	@Override
	public void delete(Session session) {
		if (session == null) {
			LogHelper.error(getClass(), "Session 不能为null");
			return;
		}
		Serializable id = session.getId();
		if (id != null) {
			repository.deleteSession(id);
		}

	}

	@Override
	public Collection<Session> getActiveSessions() {
		return null;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		repository.saveSession(session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
		repository.saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return repository.getSession(sessionId);
	}

	public RedisShiroSessionRepository getRepository() {
		return repository;
	}

	public void setRepository(RedisShiroSessionRepository repository) {
		this.repository = repository;
	}

}
