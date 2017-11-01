package org.module.model.system.user;

import org.module.base.model.BaseModel;

public class SmRolePermissions extends BaseModel {

	private static final long serialVersionUID = 1541455609986323851L;

	private String code;

	private String name;

	private String enName;

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

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

}