package org.module.model.system.role;

import org.module.model.BaseModel;

public class SmRolePermission extends BaseModel {

	private String roleCode;

	private String menuPermissionCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getMenuPermissionCode() {
		return menuPermissionCode;
	}

	public void setMenuPermissionCode(String menuPermissionCode) {
		this.menuPermissionCode = menuPermissionCode;
	}

}