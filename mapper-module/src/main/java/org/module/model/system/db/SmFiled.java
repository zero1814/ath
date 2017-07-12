package org.module.model.system.db;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_filed", database = "systemmodule", comment = "页面显示字段维护表")
public class SmFiled extends BaseModel {

	private static final long serialVersionUID = 5837827207956341076L;

	@Column(name = "table_code", isNull = false, comment = "数据表编码")
	private String tableCode;

	@Column(name = "field-code", isNull = false, comment = "字段编码")
	private String fieldCode;

	@Column(name = "field_name", isNull = false, comment = "字段名称")
	private String fieldName;

	@Column(name = "fieldtype", isNull = false, comment = "字段类型")
	private String fieldType;

	@Column(name = "field_length", defaultValue = "0", comment = "字段长度")
	private Integer fieldLength;

	@Column(name = "numeric_scale", defaultValue = "0", comment = "字段小数点保留位数")
	private Integer numericScale;

	@Column(name = "is_nullable", defaultValue = "0", comment = "是否可以为空 0 可以 1 不可以")
	private Integer isNullable;

	@Column(name = "field_default", comment = "字段默认值")
	private String fieldDefault;
	@Column(name = "field_key", comment = "字段索引类型")
	private String fieldKey;

	@Column(name = "sort_add", defaultValue = "0", comment = "排序添加")
	private Integer sortAdd;

	@Column(name = "sort_edit", defaultValue = "0", comment = "排序修改")
	private Integer sortEdit;

	@Column(name = "sort_chart", defaultValue = "0", comment = "排序列表")
	private Integer sortChart;

	@Column(name = "sort_book", defaultValue = "0", comment = "排序展示")
	private Integer sortBook;

	@Column(name = "sort_inquery", defaultValue = "0", comment = "排序查询")
	private Integer sortInquery;

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(Integer fieldLength) {
		this.fieldLength = fieldLength;
	}

	public Integer getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(Integer numericScale) {
		this.numericScale = numericScale;
	}

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	public Integer getSortAdd() {
		return sortAdd;
	}

	public void setSortAdd(Integer sortAdd) {
		this.sortAdd = sortAdd;
	}

	public Integer getSortEdit() {
		return sortEdit;
	}

	public void setSortEdit(Integer sortEdit) {
		this.sortEdit = sortEdit;
	}

	public Integer getSortChart() {
		return sortChart;
	}

	public void setSortChart(Integer sortChart) {
		this.sortChart = sortChart;
	}

	public Integer getSortBook() {
		return sortBook;
	}

	public void setSortBook(Integer sortBook) {
		this.sortBook = sortBook;
	}

	public Integer getSortInquery() {
		return sortInquery;
	}

	public void setSortInquery(Integer sortInquery) {
		this.sortInquery = sortInquery;
	}

	public Integer getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(Integer isNullable) {
		this.isNullable = isNullable;
	}

}