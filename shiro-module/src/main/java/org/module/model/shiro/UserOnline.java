package org.module.model.shiro;

import org.module.model.system.user.SmUser;

public class UserOnline extends SmUser {
	private static final long serialVersionUID = 1944529728812048578L;
	// Session Id
	private String sessionId;
	// Session Host
	private String host;
	// Session创建时间
	private String startTime;
	// Session最后交互时间
	private String lastAccess;
	// Session timeout
	private long timeout;

	/**
	 * 最后登录时间
	 */
	private String lastLoginTime;
	// session 是否踢出
	private boolean sessionStatus = Boolean.TRUE;

	public UserOnline() {
	}

	public UserOnline(SmUser user) {
		super(user);
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
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
