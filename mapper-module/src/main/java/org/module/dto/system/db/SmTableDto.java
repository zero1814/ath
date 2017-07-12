package org.module.dto.system.db;

import org.module.dto.BaseDto;

public class SmTableDto extends BaseDto {

	private String tableCode;

	private String tableName;

	private String type;

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
