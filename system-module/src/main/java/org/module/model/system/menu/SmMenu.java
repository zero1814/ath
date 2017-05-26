package org.module.model.system.menu;

import java.util.List;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.TreeModel;

@Table(database = "systemmodule", name = "sm_menu", comment = "菜单表")
@Object(name = "系统菜单", description = "管理系统菜单")
public class SmMenu extends TreeModel {

	@Column(name = "parent_code", comment = "父级编码", defaultValue = "0")
	@Attribute(name = "parentCode", description = "上级菜单编码", defaultValue = "0")
	private String parentCode;

	@Attribute(name = "parentName", description = "上级菜单名称")
	private String parentName;

	@Column(name = "group_code", comment = "所属菜单组编码", isNull = false)
	@Attribute(name = "groupCode", description = "所属菜单组编码", isNull = false)
	private String groupCode;

	@Attribute(name = "groupName", description = "所属菜单组名称")
	private String groupName;

	@Column(name = "name", comment = "名称", isNull = false)
	@Attribute(name = "name", description = "名称", isNull = false)
	private String name;

	@Attribute(name = "pageName", description = "访问页面名称")
	private String pageName;

	@Attribute(name = "url", description = "访问地址")
	@Column(name = "url", comment = "访问url地址")
	private String url;

	@Column(name = "icon", comment = "菜单图标")
	@Attribute(name = "icon", description = "菜单图标")
	private String icon;

	@Column(name = "flag_able", comment = "是否可用", defaultValue = "0")
	@Attribute(name = "flagAble", description = "是否可用", defaultValue = "0")
	private Integer flagAble;

	@Column(name = "is_deleted", comment = "是否已删除", defaultValue = "0")
	@Attribute(name = "isDeleted", description = "是否已删除", defaultValue = "0")
	private Integer isDeleted;

	@Attribute(name = "childMenu", description = "子菜单集合")
	private List<SmMenu> childMenu;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SmMenu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<SmMenu> childMenu) {
		this.childMenu = childMenu;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

}