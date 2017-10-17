package org.module.dto.system.page;

import org.module.base.dto.BaseDto;

public class SmPageTableColumnDto extends BaseDto {

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
