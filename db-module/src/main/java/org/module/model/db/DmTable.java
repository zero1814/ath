package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmTable <br>
 * 描述: 数据表维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午3:20:23
 */
public class DmTable extends BaseModel {

	/**
	 * 数据库编码
	 */
	private String dbCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String comment;

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