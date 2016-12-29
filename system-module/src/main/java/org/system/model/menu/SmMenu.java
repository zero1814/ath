package org.system.model.menu;

import org.commons.annotation.obj.AttributeExplain;
import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseModel;

@ObjectExplain(name = "系统菜单维护", description = "维护系统相关菜单信息")
public class SmMenu extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "菜单编码")
	private String code;

	@AttributeExplain(name = "parentCode", description = "菜单父级编码")
	private String parentCode;

	@AttributeExplain(name = "groupCode", isNull = false, description = "菜单组编码")
	private String groupCode;

	@AttributeExplain(name = "name", isNull = false, description = "菜单名称")
	private String name;

	@AttributeExplain(name = "url", description = "菜单链接地址")
	private String url;

	@AttributeExplain(name = "flagAble", description = "菜单是否可用 0 可用 1不可用", defaultVal = "0")
	private Integer flagAble;

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

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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

	public Integer getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(Integer flagAble) {
		this.flagAble = flagAble;
	}

}