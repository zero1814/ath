package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmTableSql <br>
 * 描述: 数据表操作sql维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月27日 上午9:38:30
 */
public class DmTableSql extends BaseModel {

	private static final long serialVersionUID = -6192846379477056822L;

	private String tableCode;

	private String name;


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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}