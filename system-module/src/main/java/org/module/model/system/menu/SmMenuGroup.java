package org.module.model.system.menu;

import java.util.List;

import org.module.commons.annotation.obj.AttributeExplain;
import org.module.commons.annotation.obj.ObjectExplain;
import org.module.model.BaseModel;

import com.alibaba.fastjson.annotation.JSONField;

@ObjectExplain(name = "系统菜单组", description = "")
public class SmMenuGroup extends BaseModel {

	@AttributeExplain(name = "菜单组编码", isNull = false)
	@JSONField(name = "code")
	private String code;

	@AttributeExplain(name = "菜单组名称;", isNull = false)
	@JSONField(name = "name")
	private String name;

	@AttributeExplain(name = "菜单组;", isNull = false)
	@JSONField(name = "menus")
	private List<SmMenu> menus;

	public List<SmMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SmMenu> menus) {
		this.menus = menus;
	}

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