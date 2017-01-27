package org.module.commons.model.db;

import org.module.model.BaseModel;

public class CmColumnType extends BaseModel {

	private String name;

	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}