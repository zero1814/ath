package org.module.model.system.page;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.annotation.mapper.obj.Attribute;
import org.module.model.BaseModel;

@Table(name = "sm_page_table", database = "systemmodule", comment = "页面列表显示设置表")
public class SmPageTable extends BaseModel {

	private static final long serialVersionUID = -8726988704956565193L;

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