package org.module.dto.system;

import org.module.commons.dto.BaseDto;

public class SmDefineDto extends BaseDto{

	private String code;
	private String parentCode;
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
	
}
