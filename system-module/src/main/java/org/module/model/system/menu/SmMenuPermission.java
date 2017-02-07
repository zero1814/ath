package org.module.model.system.menu;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Table(database = "systemmodule", name = "sm_menu_permission", comment = "菜单权限表")
@Object(name = "菜单权限管理", description = "负责管理菜单访问相关权限")
public class SmMenuPermission extends BaseModel {

	@Column(name = "menu_code", comment = "菜单编码", isNull = false)
	@Attribute(name = "menuCode", description = "菜单编码", isNull = false)
	private String menuCode;

	@Attribute(name = "menuName", description = "菜单名称")
	private String menuName;

	@Column(name = "name", comment = "权限名称", isNull = false)
	@Attribute(name = "name", description = "权限名称", isNull = false)
	private String name;

	@Column(name = "description", comment = "权限描述")
	@Attribute(name = "description", description = "权限描述")
	private String description;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}