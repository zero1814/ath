package org.module.model.system.menu;

import java.util.List;

import org.module.base.model.TreeModel;

public class SmMenu extends TreeModel {

	private static final long serialVersionUID = 2394239530168081583L;

	private String parentCode;

	private String groupCode;

	private SmMenuGroup group;

	private String pageCode;

	private SmPage page;

	private String name;

	private String icon;

	private Integer flagAble;

	private Integer sort;

	private List<SmMenu> childs;

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public SmMenuGroup getGroup() {
		return group;
	}

	public void setGroup(SmMenuGroup group) {
		this.group = group;
	}

	public SmPage getPage() {
		return page;
	}

	public void setPage(SmPage page) {
		this.page = page;
	}

	public List<SmMenu> getChilds() {
		return childs;
	}

	public void setChilds(List<SmMenu> childs) {
		this.childs = childs;
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

	@Override
	public String getText() {
		return this.name;
	}

}