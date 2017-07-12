package org.module.dto.system.db;

import org.module.dto.BaseDto;

public class SmFiledDto extends BaseDto {

	private String fileCode;

	private String fileName;

	private String tableCode;

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

}
