package org.module.dto.system.role;

import org.module.dto.BaseDto;

public class SmRoleDto extends BaseDto {
	
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