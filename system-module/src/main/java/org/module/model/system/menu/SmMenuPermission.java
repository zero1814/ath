package org.module.model.system.menu;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmMenuPermission <br>
 * 描述: 菜单权限 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午1:00:15
 */
public class SmMenuPermission extends BaseModel {

	private String code;

	private String menuCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

}