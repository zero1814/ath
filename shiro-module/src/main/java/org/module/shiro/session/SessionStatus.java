package org.module.shiro.session;

import java.io.Serializable;

/**
 * 
 * 类: SessionStatus <br>
 * 描述: Session 状态 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月13日 下午3:54:19
 */
public class SessionStatus implements Serializable {

	private static final long serialVersionUID = -7925673206426744997L;

	/**
	 * 是否踢出 true:有效，false：踢出。
	 */
	private Boolean onlineStatus = Boolean.TRUE;

	public Boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

}
