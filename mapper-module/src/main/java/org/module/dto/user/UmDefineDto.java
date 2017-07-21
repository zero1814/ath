package org.module.dto.user;

import org.module.dto.BaseDto;

public class UmDefineDto extends BaseDto {

	private String name;

	private String parentCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
