package org.module.model.system;

import org.module.model.BaseModel;

public class SmPagePermissions extends BaseModel{

	private static final long serialVersionUID = 5635910306046838933L;

	private String pageCode;

    private String name;

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}