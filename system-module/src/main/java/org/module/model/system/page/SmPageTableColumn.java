package org.module.model.system.page;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_page_table_column", database = "systemmodule", comment = "页面列表显示字段设置表")
public class SmPageTableColumn extends BaseModel {

	@Column(name = "table_code", isNull = false, comment = "表编码")
	private String tableCode;

	@Column(name = "field", isNull = false, comment = "字段")
	private String field;

	@Column(name = "title", isNull = false, comment = "标题")
	private String title;

	@Column(name = "formatter", defaultValue = "", comment = "格式化程序")
	private String formatter;

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

}