package org.system.model.server;

import org.commons.annotation.model.AttributeExplain;
import org.commons.annotation.model.ModelExplain;
import org.commons.base.BaseModel;

@ModelExplain(name = "系统服务器分组", description = "系统服务器分组")
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