package org.module.model.shiro;

import java.io.Serializable;
import java.util.Date;

import org.module.model.system.user.SmUser;

/**
 * 
 * 类: UserOnline <br>
 * 描述: session信息 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月30日 下午2:06:52
 */
public class UserOnline extends SmUser implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Session Id
	 */
	private String sessionId;
	/**
	 * Session Host
	 */
	private String host;
	/**
	 * Session创建时间
	 */
	private Date startTime;

	/**
	 * Session最后交互时间
	 */
	private Date lastAccess;
	/**
	 * Session timeout
	 */
	private long timeout;
	/**
	 * session 是否踢出
	 */
	private boolean sessionStatus = Boolean.TRUE;

	public UserOnline() {
	}

	public UserOnline(SmUser user) {
		super(user);
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public boolean isSessionStatus() {
		return sessionStatus;
	}

	public void setSessionStatus(boolean sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
