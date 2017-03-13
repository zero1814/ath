package org.module.db.model;

import org.module.model.BaseModel;

/**
 * 
 * 类: DataBaseModel <br>
 * 描述: 数据库 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月13日 上午10:19:19
 */
public class DataBaseModel extends BaseModel {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
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
