package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmColumn <br>
 * 描述: 数据表列维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午3:18:36
 */
public class DmColumn extends BaseModel {

	/**
	 * 数据表编码
	 */
	private String tableCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 类型编码
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

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
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