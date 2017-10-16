package org.module.model.system;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmUser <br>
 * 描述: 系统用户表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:10:48
 */
public class SmUser extends BaseModel {

	private static final long serialVersionUID = -9150044190629937873L;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

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

}