package org.module.model.kernel.db;

import org.module.model.BaseModel;

public class CmTable extends BaseModel {

	private String name;

	private String comment;

	private String dbCode;

	private String dbName;

	private String engine;

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

	public String getDbCode() {
		return dbCode;
	}

	public void setDbCode(String dbCode) {
		this.dbCode = dbCode;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

}