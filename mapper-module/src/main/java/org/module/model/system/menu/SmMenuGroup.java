package org.module.model.system.menu;

import org.module.base.model.BaseModel;

public class SmMenuGroup extends BaseModel {

	private static final long serialVersionUID = 8662537393158959425L;

	private String code;

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