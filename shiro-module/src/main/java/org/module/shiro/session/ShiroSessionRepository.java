package org.module.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * 
 * 类: ShiroSessionRepository <br>
 * 描述: Session操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月10日 下午2:28:56
 */
public interface ShiroSessionRepository {

	/**
	 * 
	 * 方法: saveSession <br>
	 * 描述: 存储Session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月10日 下午2:29:47
	 * 
	 * @param session
	 */
	void saveSession(Session session);

	/**
	 * 
	 * 方法: deleteSession <br>
	 * 描述: 删除session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月10日 下午2:29:39
	 * 
	 * @param sessionId
	 */
	void deleteSession(Serializable sessionId);

	/**
	 * 
	 * 方法: getSession <br>
	 * 描述: 获取session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月10日 下午2:29:32
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
	 * 时间: 2017年11月10日 下午2:29:25
	 * 
	 * @return
	 */
	Collection<Session> getAllSessions();
}
