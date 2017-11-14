package org.module.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * 
 * 类: ShiroSessionRepository <br>
 * 描述: Session操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月13日 下午3:57:01
 */
public interface ShiroSessionRepository {

	/**
	 * 
	 * 方法: saveSession <br>
	 * 描述: 存储Session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午3:57:23
	 * 
	 * @param session
	 */
	void saveSession(Session session);

	/**
	 * 
	 * 方法: deleteSession <br>
	 * 描述: 删除session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午3:57:31
	 * 
	 * @param sessionId
	 */
	void deleteSession(Serializable sessionId);

	/**
	 * 
	 * 方法: getSession <br>
	 * 描述: 获取session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午3:57:39
	 * 
	 * @param sessionId
	 * @return
	 */
	Session getSession(Serializable sessionId);

	/**
	 * 
	 * 方法: getAllSessions <br>
	 * 描述: 获取所有sessoin <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月13日 下午3:57:47
	 * 
	 * @return
	 */
	Collection<Session> getAllSessions();
}
