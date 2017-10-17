package org.module.dto.system.db;

import org.module.base.dto.BaseDto;

public class SmColumnDto extends BaseDto {

	private String name;

	private String tableCode;

	private String columnNote;

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

	public String getColumnNote() {
		return columnNote;
	}

	public void setColumnNote(String columnNote) {
		this.columnNote = columnNote;
	}

}
