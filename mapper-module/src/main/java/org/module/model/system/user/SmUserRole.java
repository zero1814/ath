package org.module.model.system.user;

import org.module.base.model.BaseModel;

public class SmUserRole extends BaseModel {

	private static final long serialVersionUID = -8811826142253574416L;

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