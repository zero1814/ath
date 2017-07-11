package org.module.model.system.db;

import org.module.model.BaseModel;

public class SmFiled extends BaseModel {

	private static final long serialVersionUID = -7317432318949485965L;

	private String name;

	private String tableCode;

	private String columnCode;

	private String fieldType;

	private Integer sortAdd;

	private Integer sortEdit;

	private Integer sortChart;

	private Integer sortBook;

	private Integer sortInquery;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
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

}