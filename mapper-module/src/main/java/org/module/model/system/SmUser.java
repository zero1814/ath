package org.module.model.system;

import org.module.model.BaseModel;

public class SmUser extends BaseModel {

	private static final long serialVersionUID = -9150044190629937873L;

	private String userName;

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