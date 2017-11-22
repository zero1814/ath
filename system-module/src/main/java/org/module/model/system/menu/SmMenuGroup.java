package org.module.model.system.menu;

import java.util.List;

import org.module.commons.model.BaseModel;

public class SmMenuGroup extends BaseModel {

	private static final long serialVersionUID = 468668498709716640L;

	private String name;

	private List<SmMenu> menus;

	public List<SmMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SmMenu> menus) {
		this.menus = menus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}