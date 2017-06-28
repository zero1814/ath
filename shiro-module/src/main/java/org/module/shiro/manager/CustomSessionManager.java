package org.module.shiro.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.module.model.system.user.SmUser;
import org.module.shiro.dao.CustomShiroSessionDAO;
import org.module.shiro.model.SessionStatus;
import org.module.shiro.model.User;
import org.module.shiro.session.ShiroSessionRepository;

public class CustomSessionManager {
	public static final String SESSION_STATUS = "ath-user-online-status";

	ShiroSessionRepository shiroSessionRepository;

	CustomShiroSessionDAO customShiroSessionDAO;

	/**
	 * 获取所有的有效Session用户
	 * 
	 * @return
	 */
	public List<User> getAllUser() {
		// 获取所有session
		Collection<Session> sessions = customShiroSessionDAO.getActiveSessions();
		List<User> list = new ArrayList<User>();

		for (Session session : sessions) {
			User bo = getSessionUser(session);
			if (null != bo) {
				list.add(bo);
			}
		}
		return list;
	}

	private User getSessionUser(Session session) {
		// 获取session登录信息。
		Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
		if (null == obj) {
			return null;
		}
		// 确保是 SimplePrincipalCollection对象。
		if (obj instanceof SimplePrincipalCollection) {
			SimplePrincipalCollection spc = (SimplePrincipalCollection) obj;
			/**
			 * 获取用户登录的，@link SampleRealm.doGetAuthenticationInfo(...)方法中 return
			 * new SimpleAuthenticationInfo(user,user.getPswd(),
			 * getName());的user 对象。
			 */
			obj = spc.getPrimaryPrincipal();
			if (null != obj && obj instanceof SmUser) {
				// 存储session + user 综合信息
				User sessionUser = new User((SmUser) obj);
				// 主机的ip地址
				sessionUser.setHost(session.getHost());
				// session ID
				sessionUser.setSessionId(session.getId().toString());
				// session最后一次与系统交互的时间
				sessionUser.setLastAccess(session.getLastAccessTime());
				// 回话到期 ttl(ms)
				sessionUser.setTimeout(session.getTimeout());
				// session创建时间
				sessionUser.setStartTime(session.getStartTimestamp());
				// 是否踢出
				SessionStatus sessionStatus = (SessionStatus) session.getAttribute(SESSION_STATUS);
				boolean status = Boolean.TRUE;
				if (null != sessionStatus) {
					status = sessionStatus.getOnlineStatus();
				}
				sessionUser.setSessionStatus(status);
				return sessionUser;
			}
		}
		return null;
	}

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

	public CustomShiroSessionDAO getCustomShiroSessionDAO() {
		return customShiroSessionDAO;
	}

	public void setCustomShiroSessionDAO(CustomShiroSessionDAO customShiroSessionDAO) {
		this.customShiroSessionDAO = customShiroSessionDAO;
	}

}
