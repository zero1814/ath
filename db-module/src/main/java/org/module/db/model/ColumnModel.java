package org.module.db.model;

import org.module.model.BaseModel;

/**
 * 
 * 类: ColumnModel <br>
 * 描述: 数据表列 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月13日 上午10:19:26
 */
public class ColumnModel extends BaseModel {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 默认值
	 */
	private String defaultValue;
	/**
	 * 描述
	 */
	private String comment;
	/**
	 * 是否为空
	 */
	private boolean isNull;

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
