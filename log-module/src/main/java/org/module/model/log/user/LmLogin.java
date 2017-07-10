package org.module.model.log.user;

import org.module.model.BaseModel;

public class LmLogin extends BaseModel {

	private static final long serialVersionUID = -6760780060160848405L;

	private String userCode;

	private String ip;

	private String loginTime;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

}