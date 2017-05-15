package org.module.model.user;

import org.module.model.BaseModel;
/**
 * 
 * 类: UmDefine <br>
 * 描述: 参数表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月15日 上午9:20:54
 */
public class UmDefine extends BaseModel {

	private String parentCode;

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