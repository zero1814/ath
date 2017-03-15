package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmTableSql <br>
 * 描述: 数据表操作sql维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午3:21:43
 */
public class DmTableSql extends BaseModel {

	/**
	 * 数据表编码
	 */
	private String tableCode;

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

	/**
	 * sql内容
	 */
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}