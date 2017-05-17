package org.module.model.system.user;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmUser <br>
 * 描述: 用户表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月9日 上午10:23:49
 */
public class SmUser extends BaseModel {

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 状态
	 */
	private String status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}