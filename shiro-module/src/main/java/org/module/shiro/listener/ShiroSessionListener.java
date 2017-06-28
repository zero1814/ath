package org.module.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.module.helper.commons.LogHelper;

public class ShiroSessionListener implements SessionListener {

	@Override
	public void onExpiration(Session session) {
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

}
