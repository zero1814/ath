package org.system.model;

import org.module.commons.annotation.model.AttributeExplain;
import org.module.commons.annotation.model.ModelExplain;
import org.module.commons.base.BaseModel;

@ModelExplain(name = "系统参数", description = "设置系统相关参数")
public class SmDefine extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "参数编码")
	private String code;

	@AttributeExplain(name = "parentCode", description = "参数父级编码")
	private String parentCode;

	@AttributeExplain(name = "name", isNull = false, description = "参数名称")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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