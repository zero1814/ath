package org.module.model.system.page;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.annotation.mapper.obj.Attribute;
import org.module.model.BaseModel;

@Table(name = "sm_page_table_column", database = "systemmodule", comment = "页面列表显示字段设置表")
public class SmPageTableColumn extends BaseModel {

	private static final long serialVersionUID = -4233724525116029494L;

	@Column(name = "table_code", isNull = false, comment = "表编码")
	private String tableCode;

	@Column(name = "field", isNull = false, comment = "字段")
	private String field;

	@Column(name = "title", isNull = false, comment = "标题")
	private String title;

	@Column(name = "formatter", defaultValue = "", comment = "格式化程序")
	private String formatter;

	@Attribute(name = "页面显示列表")
	private SmPageTable table;

	public SmPageTable getTable() {
		return table;
	}

	public void setTable(SmPageTable table) {
		this.table = table;
	}

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