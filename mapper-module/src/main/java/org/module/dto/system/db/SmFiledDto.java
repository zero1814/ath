package org.module.dto.system.db;

import org.module.dto.BaseDto;

public class SmFiledDto extends BaseDto {

	private String name;

	private String tableCode;

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

}
