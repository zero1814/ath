package org.module.shiro.session;

import java.io.Serializable;

/**
 * 
 * 类: SessionStatus <br>
 * 描述: Session 状态 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月10日 下午2:48:02
 */
public class SessionStatus implements Serializable {
	private static final long serialVersionUID = 121881421794745477L;

	/**
	 * 是否踢出 true:有效，false：踢出。
	 */
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
