package org.module.model.system.menu;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_page", database = "systemmodule", comment = "页面表")
public class SmPage extends BaseModel {

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

}