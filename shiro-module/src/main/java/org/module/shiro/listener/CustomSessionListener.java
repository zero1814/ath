package org.module.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.module.helper.commons.LogHelper;
import org.module.shiro.RedisShiroSessionRepository;

public class CustomSessionListener implements SessionListener {

	private RedisShiroSessionRepository repository;

	@Override
	public void onExpiration(Session session) {
		repository.deleteSession(session.getId());
		LogHelper.info(getClass(), session.getId() + ":expiration......");
	}

	@Override
	public void onStart(Session session) {
		LogHelper.info(getClass(), session.getId() + ":start......");
	}

	@Override
	public void onStop(Session session) {
		LogHelper.info(getClass(), session.getId() + ":stop......");
	}

	public RedisShiroSessionRepository getRepository() {
		return repository;
	}

	public void setRepository(RedisShiroSessionRepository repository) {
		this.repository = repository;
	}

}
