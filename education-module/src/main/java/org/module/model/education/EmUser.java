package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmUser <br>
 * 描述: 用户表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:53:14
 */
public class EmUser extends BaseModel {

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户类型
	 */
	private String typeCode;

	/**
	 * 用户状态
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

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}