package org.module.model.system.user;

import org.module.base.model.BaseModel;

public class SmRole extends BaseModel {

	private static final long serialVersionUID = -3478033071258950080L;

	private String code;

	private String name;

	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}