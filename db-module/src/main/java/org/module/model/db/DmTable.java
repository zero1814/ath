package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmTable <br>
 * 描述: 数据表维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月27日 上午9:37:18
 */
public class DmTable extends BaseModel {

	private String dbCode;

	private String name;

	private String enName;

	private String comment;

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getDbCode() {
		return dbCode;
	}

	public void setDbCode(String dbCode) {
		this.dbCode = dbCode;
	}

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