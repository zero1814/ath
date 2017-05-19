package org.module.model.system;

import java.util.List;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

/**
 * 
 * 类: SmDefine <br>
 * 描述: 系统模块参数表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月9日 上午10:26:20
 */
@Table(database = "systemmodule", name = "sm_define", comment = "系统模块参数表")
@Object(name = "系统模块参数表", description = "配置系统模块相关")
public class SmDefine extends BaseModel {

	/**
	 * 父级编码
	 */
	@Column(name = "parent_code", comment = "父级编码")
	@Attribute(name = "parentCode", description = "父级编码")
	private String parentCode;

	@Column(name = "name", comment = "名称")
	@Attribute(name = "name", description = "名称")
	private String name;

	@Attribute(name = "subDefine", description = "子级参数列表")
	private List<SmDefine> subDefine;

	public List<SmDefine> getSubDefine() {
		return subDefine;
	}

	public void setSubDefine(List<SmDefine> subDefine) {
		this.subDefine = subDefine;
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