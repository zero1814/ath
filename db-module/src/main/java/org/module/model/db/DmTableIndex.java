package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmTableIndex <br>
 * 描述: 数据表索引维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午3:20:55
 */
public class DmTableIndex extends BaseModel {

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
	 * 关联列数组
	 */
	private String content;

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

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}