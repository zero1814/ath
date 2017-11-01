package org.module.model.system.menu;

import java.util.List;

import org.module.base.model.TreeModel;

public class SmPage extends TreeModel {

	private static final long serialVersionUID = -3798180583074393160L;

	private String parentCode;

	private String groupCode;

	private String name;

	private String url;

	private String param;

	private Integer flagAble;

	private Integer isDeleted;

	private List<SmPage> childs;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public List<SmPage> getChilds() {
		return childs;
	}

	public void setChilds(List<SmPage> childs) {
		this.childs = childs;
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

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Integer getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(Integer flagAble) {
		this.flagAble = flagAble;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String getText() {
		return this.name;
	}

}