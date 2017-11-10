package org.module.shiro.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.module.helper.PropHelper;
import org.module.model.shiro.UserOnline;
import org.module.model.system.user.SmUser;
import org.module.shiro.CustomShiroSessionDAO;
import org.module.util.DateUtil;

/**
 * 
 * 类: CustomSessionManager <br>
 * 描述: 用户Session 手动管理 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月10日 下午2:30:12
 */
public class CustomSessionManager {

	/**
	 * session status
	 */
	public static final String SESSION_STATUS = PropHelper.getConfig("web.shiro.session.status");
	/**
	 * Session操作
	 */
	private ShiroSessionRepository shiroSessionRepository;
	/**
	 * Session 操作
	 */
	private CustomShiroSessionDAO customShiroSessionDAO;

	/**
	 * 获取所有的有效Session用户
	 * 
	 * @return
	 */
	public List<UserOnline> getAllUser() {
		// 获取所有session
		Collection<Session> sessions = customShiroSessionDAO.getActiveSessions();
		List<UserOnline> list = new ArrayList<UserOnline>();

		for (Session session : sessions) {
			UserOnline bo = getSession(session);
			if (null != bo) {
				list.add(bo);
			}
		}
		return list;
	}

	/**
	 * 获取单个Session
	 * 
	 * @param sessionId
	 * @return
	 */
	public UserOnline getSession(String sessionId) {
		Session session = shiroSessionRepository.getSession(sessionId);
		UserOnline bo = getSession(session);
		return bo;
	}

	private UserOnline getSession(Session session) {
		// 获取session登录信息。
		Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
		if (null == obj) {
			return null;
		}
		// 确保是 SimplePrincipalCollection对象。
		if (obj instanceof SimplePrincipalCollection) {
			SimplePrincipalCollection spc = (SimplePrincipalCollection) obj;
			/**
			 * 获取用户登录的，@link SampleRealm.doGetAuthenticationInfo(...)方法中 return new
			 * SimpleAuthenticationInfo(user,user.getPswd(), getName());的user 对象。
			 */
			obj = spc.getPrimaryPrincipal();
			if (null != obj && obj instanceof SmUser) {
				// 存储session + user 综合信息
				UserOnline userOnline = new UserOnline((SmUser) obj);
				// 最后一次和系统交互的时间
				userOnline.setLastAccess(DateUtil.dateTimeToString(session.getLastAccessTime()));
				// 主机的ip地址
				userOnline.setHost(session.getHost());
				// session ID
				userOnline.setSessionId(session.getId().toString());
				// session最后一次与系统交互的时间
				userOnline.setLastLoginTime(DateUtil.dateTimeToString(session.getLastAccessTime()));
				// 回话到期 ttl(ms)
				userOnline.setTimeout(session.getTimeout());
				// session创建时间
				userOnline.setStartTime(DateUtil.dateTimeToString(session.getStartTimestamp()));
				// 是否踢出
				SessionStatus sessionStatus = (SessionStatus) session.getAttribute(SESSION_STATUS);
				boolean status = Boolean.TRUE;
				if (null != sessionStatus) {
					status = sessionStatus.getOnlineStatus();
				}
				userOnline.setSessionStatus(status);
				return userOnline;
			}
		}
		return null;
	}
}
