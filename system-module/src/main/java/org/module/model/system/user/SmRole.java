package org.module.model.system.user;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.base.model.BaseModel;

@Table(name = "sm_role", database = "systemmodule", comment = "角色表")
public class SmRole extends BaseModel{

	private static final long serialVersionUID = 7679446187453564912L;
	
	@Column(name = "名称", isNull = false, comment = "角色名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}