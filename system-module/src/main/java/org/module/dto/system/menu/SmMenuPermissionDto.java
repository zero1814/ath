package org.module.dto.system.menu;

import org.module.dto.BaseDto;

public class SmMenuPermissionDto extends BaseDto {

	private String name;

	private String menuCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

}