package org.module.shiro.session;

import java.io.Serializable;

/**
 * 
 * 类: SessionStatus <br>
 * 描述: session状态 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月26日 下午12:15:15
 */
public class SessionStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	// 是否踢出 true:有效，false：踢出。
	private Boolean onlineStatus = Boolean.TRUE;

	public Boolean isOnlineStatus() {
		return onlineStatus;
	}

	public Boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
}
