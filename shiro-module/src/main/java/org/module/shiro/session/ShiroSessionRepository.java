package org.module.shiro.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * 类: ShiroSessionRepository <br>
 * 描述: session相关操作方法 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月26日 上午11:39:49
 */
public interface ShiroSessionRepository {

	/**
	 * 
	 * 方法: saveSession <br>
	 * 描述: 存储Session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午12:22:19
	 * 
	 * @param session
	 */
	void saveSession(Session session);

	/**
	 * 
	 * 方法: deleteSession <br>
	 * 描述: 删除session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午12:22:12
	 * 
	 * @param sessionId
	 */
	void deleteSession(Serializable sessionId);

	/**
	 * 
	 * 方法: getSession <br>
	 * 描述: 获取session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午12:22:04
	 * 
	 * @param sessionId
	 * @return
	 */
	Session getSession(Serializable sessionId);

	/**
	 * 
	 * 方法: getAllSessions <br>
	 * 描述: 获取所有sessoin<br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月26日 下午12:21:54
	 * 
	 * @return
	 */
	Collection<Session> getAllSessions();
}
