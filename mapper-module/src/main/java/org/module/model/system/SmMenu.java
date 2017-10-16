package org.module.model.system;

import org.module.model.BaseModel;

public class SmMenu extends BaseModel {

	private static final long serialVersionUID = 7041812287357425606L;

	private String parentCode;

	private String name;

	private String pageCode;

	private String status;

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

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}