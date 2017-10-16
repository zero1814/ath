package org.module.model.system;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmPagePermissions <br>
 * 描述: 页面权限表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:09:59
 */
public class SmPagePermissions extends BaseModel{

	private static final long serialVersionUID = 5635910306046838933L;

	/**
	 * 页面编码
	 */
	private String pageCode;

	/**
	 * 名称
	 */
    private String name;

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}