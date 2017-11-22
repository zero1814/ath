package org.module.model.system;

import java.util.List;

import org.module.commons.model.BaseModel;

/**
 * 
 * 类: SmCode <br>
 * 描述: 系统参数表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午10:18:13
 */
public class SmDefine extends BaseModel {

	private static final long serialVersionUID = -2783842845265787631L;

	private String parentCode;

	private String name;

	private List<SmDefine> childs;

	public List<SmDefine> getChilds() {
		return childs;
	}

	public void setChilds(List<SmDefine> childs) {
		this.childs = childs;
	}

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