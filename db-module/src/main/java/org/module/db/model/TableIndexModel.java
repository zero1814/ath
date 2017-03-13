package org.module.db.model;

import org.module.model.BaseModel;

/**
 * 
 * 类: TableIndexModel <br>
 * 描述: 数据表索引 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月13日 上午10:19:34
 */
public class TableIndexModel extends BaseModel {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String commment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCommment() {
		return commment;
	}

	public void setCommment(String commment) {
		this.commment = commment;
	}

}
