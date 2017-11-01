package org.module.dto.system.menu;

import org.module.base.dto.BaseDto;

public class SmMenuDto extends BaseDto {

	private String parentCode;
	private String groupCode;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

}
