package org.module.model.user;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.TreeModel;

@Table(name = "um_define", database = "usermodule", comment = "用户模块参数表")
public class UmDefine extends TreeModel {

	private static final long serialVersionUID = -397891625518008409L;

	@Column(name = "parentCode", defaultValue = "0", comment = "父级编码")
	private String parentCode;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

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

	@Override
	public String getText() {
		return this.name;
	}
}