package org.module.model.system;

import org.module.model.BaseModel;

public class SmDefine extends BaseModel {

	private String parentCode;

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