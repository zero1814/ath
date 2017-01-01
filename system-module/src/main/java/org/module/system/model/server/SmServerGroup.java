package org.module.system.model.server;

import org.module.commons.annotation.obj.AttributeExplain;
import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseModel;

@ObjectExplain(name = "系统服务器分组", description = "系统服务器分组")
public class SmServerGroup extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "组编码")
	private String code;

	@AttributeExplain(name = "name", isNull = false, description = "组名称")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}