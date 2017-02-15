package org.module.model.system.page;

import org.module.model.BaseModel;

public class SmPageAuthority extends BaseModel {

	private String pageCode;

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