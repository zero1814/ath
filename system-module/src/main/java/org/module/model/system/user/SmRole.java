package org.module.model.system.user;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_role", database = "systemmodule", comment = "角色表")
public class SmRole extends BaseModel{

	@Column(name = "名称", isNull = false, comment = "角色名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}