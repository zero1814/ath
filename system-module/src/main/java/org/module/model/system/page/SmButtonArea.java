package org.module.model.system.page;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Object(name = "按钮操作区域", description = "按钮操作区域")
public class SmButtonArea extends BaseModel {

	@Attribute(name = "名称", isNull = false)
	@Column(name = "name", comment = "名称", isNull = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}