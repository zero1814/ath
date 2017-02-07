package org.module.model.system.menu;

import org.module.model.BaseModel;

public class SmMenuPermission extends BaseModel {

	private String menuCode;

	private String name;

	private String description;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}