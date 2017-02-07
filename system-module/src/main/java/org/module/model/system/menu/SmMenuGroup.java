package org.module.model.system.menu;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Table(database = "systemmodule", name = "sm_menu_group", comment = "菜单组表")
@Object(name = "系统菜单组", description = "管理系统菜单组")
public class SmMenuGroup extends BaseModel {

	@Column(name = "name", comment = "名称", isNull = false)
	@Attribute(name = "name", description = "名称", isNull = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}