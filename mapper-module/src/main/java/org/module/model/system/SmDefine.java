package org.module.model.system;

import org.module.base.model.BaseModel;

public class SmDefine extends BaseModel {

	private static final long serialVersionUID = 7746697462737470920L;

	private String code;

	private String parentCode;

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