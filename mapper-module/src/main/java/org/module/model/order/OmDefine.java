package org.module.model.order;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.TreeModel;

@Table(name = "om_define", database = "ordermodule", comment = "订单模块参数表")
public class OmDefine extends TreeModel {

	private static final long serialVersionUID = 1726254559659588473L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "parent_code", defaultValue = "0", comment = "父级编码")
	private String parentCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}