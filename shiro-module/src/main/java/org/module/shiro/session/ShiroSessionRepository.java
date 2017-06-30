package org.module.shiro.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * 类: ShiroSessionRepository <br>
 * 描述: Session操作 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月30日 下午2:02:58
 */
public interface ShiroSessionRepository {

	/**
	 * 
	 * 方法: saveSession <br>
	 * 描述: 存储Session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月30日 下午2:03:04
	 * 
	 * @param session
	 */
	void saveSession(Session session);

	/**
	 * 
	 * 方法: deleteSession <br>
	 * 描述: 删除session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月30日 下午2:03:10
	 * 
	 * @param sessionId
	 */
	void deleteSession(Serializable sessionId);

	/**
	 * 
	 * 方法: getSession <br>
	 * 描述: 获取session <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月30日 下午2:03:18
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
	 * 时间: 2017年6月30日 下午2:03:25
	 * 
	 * @return
	 */
	Collection<Session> getAllSessions();
}
