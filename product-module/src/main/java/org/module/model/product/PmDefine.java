package org.module.model.product;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.TreeModel;

@Table(name = "pm_define", database = "productmodule", comment = "商品参数表，存储类型，状态，标签等")
public class PmDefine extends TreeModel {

	private static final long serialVersionUID = -1338795044175087529L;

	@Column(name = "parent_code", isNull = false, comment = "父级编码")
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