package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmColumnType <br>
 * 描述: 数据表列类型维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月27日 上午9:36:31
 */
public class DmColumnType extends BaseModel {

	private static final long serialVersionUID = 1369420691310735330L;

	private String name;

	private String value;

	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}