package org.module.model.system.db;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.annotation.mapper.obj.Attribute;
import org.module.model.BaseModel;

@Table(name = "sm_column", database = "systemmodule", comment = "数据表字段维护表")
public class SmColumn extends BaseModel {

	private static final long serialVersionUID = 6896417927640705623L;

	@Column(name = "table_code", isNull = false, comment = "数据表编码")
	private String tableCode;

	@Column(name = "name", isNull = false, comment = "字段名称")
	private String name;

	@Column(name = "show_name", isNull = false, comment = "展示字段名称")
	private String showName;

	@Column(name = "column_note", comment = "字段描述")
	private String columnNote;

	@Column(name = "column_type", isNull = false, comment = "字段类型")
	private String columnType;

	@Column(name = "column_length", defaultValue = "0", comment = "字段长度")
	private Integer columnLength;

	@Column(name = "numeric_scale", defaultValue = "0", comment = "字段小数点保留位数")
	private Integer numericScale;

	@Column(name = "column_sort", defaultValue = "0", comment = "字段排序")
	private Integer columnSort;

	@Column(name = "column_key", comment = "字段索引类型")
	private String columnKey;

	@Attribute(name = "table", description = "数据表信息")
	private SmTable table;

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getColumnNote() {
		return columnNote;
	}

	public void setColumnNote(String columnNote) {
		this.columnNote = columnNote;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public Integer getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}

	public Integer getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(Integer numericScale) {
		this.numericScale = numericScale;
	}

	public Integer getColumnSort() {
		return columnSort;
	}

	public void setColumnSort(Integer columnSort) {
		this.columnSort = columnSort;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

}