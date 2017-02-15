package org.module.model.system.page;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Object(name = "页面按钮", description = "页面按钮")
public class SmPageButton extends BaseModel {

	@Attribute(name = "页面编码", isNull = false)
	@Column(name = "page_code", comment = "页面编码", isNull = false)
	private String pageCode;

	@Attribute(name = "样式编码", isNull = false)
	@Column(name = "style_code", comment = "样式编码", isNull = false)
	private String styleCode;

	@Attribute(name = "按钮操作", isNull = false)
	@Column(name = "operation", comment = "按钮操作", isNull = false)
	private String operation;

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getStyleCode() {
		return styleCode;
	}

	public void setStyleCode(String styleCode) {
		this.styleCode = styleCode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}