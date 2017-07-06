package org.module.model.system.page;

import java.util.List;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.model.TreeModel;

@Table(name = "sm_page_group", database = "systemmodule", comment = "页面分组表")
public class SmPageGroup extends TreeModel {

	private static final long serialVersionUID = 3638055273296489818L;

	@Column(name = "parent_code", isNull = false, comment = "父级编码")
	private String parentCode;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Attribute(name = "childs", description = "分组所属的子分组集合")
	private List<SmPageGroup> childs;

	@Attribute(name = "pages", description = "分组所属的页面集合")
	private List<SmPage> pages;

	public List<SmPageGroup> getChilds() {
		return childs;
	}

	public void setChilds(List<SmPageGroup> childs) {
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

	public List<SmPage> getPages() {
		return pages;
	}

	public void setPages(List<SmPage> pages) {
		this.pages = pages;
	}

	@Override
	public String getText() {
		return this.name;
	}

}