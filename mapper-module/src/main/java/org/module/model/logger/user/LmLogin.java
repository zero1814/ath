package org.module.model.logger.user;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "lm_login", database = "loggermodule", comment = "用户登录日志表")
public class LmLogin extends BaseModel {

	private static final long serialVersionUID = -7872427733709926948L;

	@Column(name = "user_code", isNull = false, comment = "用户编码")
	private String userCode;

	@Column(name = "ip", isNull = false, comment = "用户登录ip")
	private String ip;

	@Column(name = "login_time", isNull = false, comment = "用户登录时间")
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