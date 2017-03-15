package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmColumnType <br>
 * 描述: 数据表列类型维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午3:19:12
 */
public class DmColumnType extends BaseModel {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 英文简称
	 */
	private String enName;

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