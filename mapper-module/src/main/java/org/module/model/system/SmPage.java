package org.module.model.system;

import org.module.model.BaseModel;

public class SmPage extends BaseModel {

	private static final long serialVersionUID = 8634870166978736551L;

	private String parentCode;

	private String name;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}