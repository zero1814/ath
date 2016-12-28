package org.system.module.model;

import org.module.commons.annotation.model.AttributeExplain;
import org.module.commons.annotation.model.ModelExplain;
import org.module.commons.base.BaseModel;

/**
 * 
 * 类: SmDefine <br>
 * 描述: 系统参数 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午10:57:53
 */
@ModelExplain(name = "系统参数类", description = "用于设置系统相关参数")
public class SmDefine extends BaseModel {

	/**
	 * 参数编码
	 */
	@AttributeExplain(name = "code", isNull = false, description = "参数编码")
	private String code;
	/**
	 * 父级编码
	 */
	@AttributeExplain(name = "parentCode", description = "父级编码")
	private String parentCode;
	/**
	 * 参数名称
	 */
	@AttributeExplain(name = "name", isNull = false, description = "参数名称")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
