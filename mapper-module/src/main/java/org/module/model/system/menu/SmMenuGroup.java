package org.module.model.system.menu;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_menu_group", database = "systemmodule", comment = "菜单分组")
public class SmMenuGroup extends BaseModel {

	private static final long serialVersionUID = 468668498709716640L;
	
	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}