package org.module.model.system;

import org.module.model.BaseModel;

public class SmRolePermissions extends BaseModel {

	private static final long serialVersionUID = -922036811829527709L;

	private String roleCode;

	private String pageCode;

	private String pagePermissions;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getPagePermissions() {
		return pagePermissions;
	}

	public void setPagePermissions(String pagePermissions) {
		this.pagePermissions = pagePermissions;
	}

}