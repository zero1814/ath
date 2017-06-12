package org.module.model.system.page;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.model.BaseModel;

@Table(name = "sm_page_table", database = "systemmodule", comment = "页面列表显示设置表")
public class SmPageTable extends BaseModel {

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "page_code", isNull = false, comment = "页面编码")
	private String pageCode;

	@Attribute(name = "页面信息")
	private SmPage page;

	public SmPage getPage() {
		return page;
	}

	public void setPage(SmPage page) {
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

}