package org.module.model.system.menu;

import java.util.List;

import org.module.commons.annotation.obj.AttributeExplain;
import org.module.commons.annotation.obj.ObjectExplain;
import org.module.model.BaseModel;

import com.alibaba.fastjson.annotation.JSONField;

@ObjectExplain(name = "系统菜单维护", description = "维护系统相关菜单信息")
public class SmMenu extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "菜单编码")
	@JSONField(name = "code")
	private String code;

	@AttributeExplain(name = "parentCode", description = "菜单父级编码")
	@JSONField(name = "parent_code")
	private String parentCode;

	@AttributeExplain(name = "parentName", description = "菜单父级名称")
	@JSONField(name = "parent_name")
	private String parentName;

	@AttributeExplain(name = "groupCode", isNull = false, description = "菜单组编码")
	@JSONField(name = "group_code")
	private String groupCode;

	@AttributeExplain(name = "groupName", isNull = false, description = "菜单组名称")
	@JSONField(name = "group_name")
	private String groupName;

	@AttributeExplain(name = "name", isNull = false, description = "菜单名称")
	@JSONField(name = "name")
	private String name;

	@AttributeExplain(name = "url", description = "菜单链接地址")
	@JSONField(name = "url")
	private String url;

	@AttributeExplain(name = "icon", description = "菜单前缀图标")
	@JSONField(name = "icon")
	private String icon;

	@AttributeExplain(name = "flagAble", description = "菜单是否可用 0 可用 1不可用", defaultVal = "0")
	@JSONField(name = "flag_able")
	private Integer flagAble;

	@AttributeExplain(name = "childMenu", description = "子级分类", defaultVal = "")
	@JSONField(name = "child_menu")
	private List<SmMenu> childMenu;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<SmMenu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<SmMenu> childMenu) {
		this.childMenu = childMenu;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

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