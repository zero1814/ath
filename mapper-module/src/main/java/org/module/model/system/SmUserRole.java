package org.module.model.system;

import org.module.model.BaseModel;

public class SmUserRole extends BaseModel {

	private static final long serialVersionUID = 8498207547797400860L;

	private String userCode;

	private String roleCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}