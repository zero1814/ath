package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmDefine <br>
 * 描述: 参数表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:43:01
 */
public class EmDefine extends BaseModel {

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