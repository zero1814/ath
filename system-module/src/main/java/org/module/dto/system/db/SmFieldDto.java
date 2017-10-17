package org.module.dto.system.db;

import org.module.base.dto.BaseDto;

public class SmFieldDto extends BaseDto {

	private String fieldCode;

	private String fieldName;

	private String tableCode;

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

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

}
