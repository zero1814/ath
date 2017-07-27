package org.module.model.system.menu;

import java.util.List;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.annotation.mapper.obj.Attribute;
import org.module.model.TreeModel;
import org.module.model.system.page.SmPage;

@Table(name = "sm_menu", database = "systemmodule", comment = "菜单表")
public class SmMenu extends TreeModel {

	private static final long serialVersionUID = 2394239530168081583L;

	@Column(name = "parent_code", comment = "父级编码")
	private String parentCode;

	@Column(name = "group_code", isNull = false, comment = "菜单分组编码")
	private String groupCode;

	@Attribute(name = "菜单分组")
	private SmMenuGroup group;

	@Column(name = "page_code", comment = "菜单对应页面编码")
	private String pageCode;

	@Attribute(name = "page", description = "菜单对应页面信息")
	private SmPage page;

	@Column(name = "name", isNull = false, comment = "菜单名称")
	private String name;

	@Column(name = "icon", comment = "菜单图标")
	private String icon;

	@Column(name = "flag_able", comment = "是否可用 0 可用 1 不可用")
	private Integer flagAble;

	@Column(name = "sort", defaultValue = "0", comment = "排序")
	private Integer sort;

	@Attribute(name = "childs", description = "子级菜单集合")
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