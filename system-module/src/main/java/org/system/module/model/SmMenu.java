package org.system.module.model;

import org.module.commons.annotation.model.AttributeExplain;
import org.module.commons.annotation.model.ModelExplain;
import org.module.commons.base.BaseModel;

/**
 * 
 * 类: SmMenu <br>
 * 描述: 系统菜单类 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午9:33:14
 */
@ModelExplain(name = "系统菜单类", description = "设置系统相关菜单信息")
public class SmMenu extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "菜单编码")
	private String code;
	@AttributeExplain(name = "parentCode", description = "父级编码")
	private String parentCode;
	@AttributeExplain(name = "name", isNull = false, description = "菜单名称")
	private String name;
	@AttributeExplain(name = "url", description = "菜单链接地址")
	private String url;
	@AttributeExplain(name = "flagAble", defaultVal = "0", description = "是否可用 0 可用 1 不可用")
	private String flagAble;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(String flagAble) {
		this.flagAble = flagAble;
	}
}
