package org.module.model.system.user;

import org.module.commons.model.BaseModel;

public class SmRolePermissions extends BaseModel {

	private static final long serialVersionUID = -2509725622063459761L;

	private String name;

	private String enName;

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