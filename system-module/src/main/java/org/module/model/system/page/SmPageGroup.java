package org.module.model.system.page;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_page_group", database = "systemmodule", comment = "页面分组表")
public class SmPageGroup extends BaseModel {

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}