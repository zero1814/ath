package org.module.model.system;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmDefine <br>
 * 描述: 系统模块参数表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月9日 上午10:26:20
 */
public class SmDefine extends BaseModel {

	/**
	 * 父级编码
	 */
	private String parentCode;

	/**
	 * 名称
	 */
	private String name;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}