package org.module.model.system.page;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Object(name = "页面权限", description = "页面权限")
public class SmPageAuthority extends BaseModel {

	@Attribute(name = "页面编码", isNull = false)
	@Column(name = "page_code", comment = "页面编码", isNull = false)
	private String pageCode;

	@Attribute(name = "操作权限", isNull = false)
	@Column(name = "authority", comment = "操作权限", isNull = false)
	private String authority;

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}