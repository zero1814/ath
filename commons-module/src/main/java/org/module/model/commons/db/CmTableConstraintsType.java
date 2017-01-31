package org.module.model.commons.db;

import org.module.model.BaseModel;

public class CmTableConstraintsType extends BaseModel {

	private String name;

	private String enName;

	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}