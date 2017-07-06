package org.module.shiro.listenter;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.module.shiro.session.ShiroSessionRepository;

/**
 * 
 * 类: CustomSessionListener <br>
 * 描述: shiro 回话 监听 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月3日 上午10:42:30
 */
public class CustomSessionListener implements SessionListener {

	private ShiroSessionRepository shiroSessionRepository;

	/**
	 * 一个回话的生命周期开始
	 */
	@Override
	public void onStart(Session session) {
	}

	/**
	 * 一个回话的生命周期结束
	 */
	@Override
	public void onStop(Session session) {
	}

	@Override
	public void onExpiration(Session session) {
		shiroSessionRepository.deleteSession(session.getId());
	}

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

}
