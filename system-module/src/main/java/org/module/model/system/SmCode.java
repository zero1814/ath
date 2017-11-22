package org.module.model.system;

import org.module.commons.model.BaseModel;

public class SmCode extends BaseModel {

	private static final long serialVersionUID = 4647549345769801187L;

	private String codeStart;

	private String dateApply;

	private Integer minNumber;

	private Integer nowNumber;

	private String codeNote;

	private Integer flagDate;

	public String getCodeStart() {
		return codeStart;
	}

	public void setCodeStart(String codeStart) {
		this.codeStart = codeStart;
	}

	public String getDateApply() {
		return dateApply;
	}

	public void setDateApply(String dateApply) {
		this.dateApply = dateApply;
	}

	public Integer getMinNumber() {
		return minNumber;
	}

	public void setMinNumber(Integer minNumber) {
		this.minNumber = minNumber;
	}

	public Integer getNowNumber() {
		return nowNumber;
	}

	public void setNowNumber(Integer nowNumber) {
		this.nowNumber = nowNumber;
	}

	public String getCodeNote() {
		return codeNote;
	}

	public void setCodeNote(String codeNote) {
		this.codeNote = codeNote;
	}

	public Integer getFlagDate() {
		return flagDate;
	}

	public void setFlagDate(Integer flagDate) {
		this.flagDate = flagDate;
	}

}