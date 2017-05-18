package org.module.model.system.user;

import org.module.model.BaseModel;
/**
 * 
 * 类: SmUser <br>
 * 描述: 用户表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 上午8:06:29
 */
public class SmUser extends BaseModel {

	private String userName;

	private String password;

	private String realName;

	private String typeCode;

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