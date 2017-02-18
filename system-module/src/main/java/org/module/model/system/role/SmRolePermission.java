package org.module.model.system.role;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Table(database = "systemmodule", name = "sm_role_permission", comment = "角色权限表")
@Object(name = "角色权限配置", description = "配置角色访问权限")
public class SmRolePermission extends BaseModel {

	@Column(name = "role_code", comment = "角色编码", isNull = false)
	@Attribute(name = "roleCode", description = "角色编码", isNull = false)
	private String roleCode;

	@Column(name = "menu_code", comment = "菜单编码", isNull = false)
	@Attribute(name = "menuCode", description = "菜单编码", isNull = false)
	private String menuCode;

	@Column(name = "menu_permission_code", comment = "菜单权限编码", isNull = false)
	@Attribute(name = "menuPermissionCode", description = "菜单权限编码", isNull = false)
	private String menuPermissionCode;

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

	public String getMenuPermissionCode() {
		return menuPermissionCode;
	}

	public void setMenuPermissionCode(String menuPermissionCode) {
		this.menuPermissionCode = menuPermissionCode;
	}

}