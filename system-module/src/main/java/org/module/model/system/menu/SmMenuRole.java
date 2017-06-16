package org.module.model.system.menu;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_menu_role", database = "systemmodule", comment = "菜单角色关系表")
public class SmMenuRole extends BaseModel {

	@Column(name = "menu_code", isNull = false, comment = "菜单编码")
	private String menuCode;

	@Column(name = "role_code", isNull = false, comment = "角色编码")
	private String roleCode;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}