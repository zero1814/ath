package org.system.model.menu;

import org.commons.annotation.model.AttributeExplain;
import org.commons.annotation.model.ModelExplain;
import org.commons.base.BaseModel;

@ModelExplain(name = "系统菜单组", description = "")
public class SmMenuGroup extends BaseModel {

	@AttributeExplain(name = "菜单组编码", isNull = false)
	private String code;

	@AttributeExplain(name = "菜单组名称;", isNull = false)
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