package org.module.dto.user;

import org.module.dto.BaseDto;

public class UmStoreInfoDto extends BaseDto {

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