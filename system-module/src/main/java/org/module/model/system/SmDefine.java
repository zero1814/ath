package org.module.model.system;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Table(database = "systemmodule", name = "sm_define", comment = "系统参数表")
@Object(name = "系统参数", description = "管理系统参数")
public class SmDefine extends BaseModel {

	@Column(name = "parent_code", comment = "父级编码", defaultValue = "0")
	@Attribute(name = "parentCode", description = "父级编码", defaultValue = "0")
	private String parentCode;

	@Column(name = "name", comment = "名称", isNull = false)
	@Attribute(name = "name", description = "名称", isNull = false)
	private String name;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}