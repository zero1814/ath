package org.module.model.system.menu;

import org.module.base.model.BaseModel;

public class SmMenu extends BaseModel {

	private static final long serialVersionUID = 6003096326931696540L;

	private String code;

	private String parentCode;

	private String groupCode;

	private String pageCode;

	private String name;

	private String icon;

	private Integer flagAble;

	private Integer sort;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(Integer flagAble) {
		this.flagAble = flagAble;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}