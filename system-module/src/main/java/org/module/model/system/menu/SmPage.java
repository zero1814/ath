package org.module.model.system.menu;

import java.util.List;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.annotation.obj.Attribute;
import org.module.base.model.TreeModel;

@Table(name = "sm_page", database = "systemmodule", comment = "页面表")
public class SmPage extends TreeModel {

	private static final long serialVersionUID = -3798180583074393160L;

	@Column(name = "parent_code", defaultValue = "0", comment = "父级编码")
	private String parentCode;

	@Column(name = "group_code", isNull = false, comment = "页面分组编码")
	private String groupCode;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "url", isNull = false, comment = "链接地址")
	private String url;

	@Column(name = "param", comment = "链接参数")
	private String param;

	@Column(name = "flag_able", comment = "是否可用 0 可用 1 不可用")
	private Integer flagAble;

	@Column(name = "is_deleted", comment = "是否已删除 0 未删除 1 已删除")
	private Integer isDeleted;

	@Attribute(name = "childs", description = "子级页面集合")
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