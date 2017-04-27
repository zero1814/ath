package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmTableIndex <br>
 * 描述: 数据表索引维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月27日 上午9:37:50
 */
public class DmTableIndex extends BaseModel {

	private String tableCode;

	private String name;

	private String enName;

	private String content;

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