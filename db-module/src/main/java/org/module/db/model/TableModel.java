package org.module.db.model;

import java.util.List;

import org.module.model.BaseModel;

/**
 * 
 * 类: TableModel <br>
 * 描述: 数据表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月13日 上午10:19:09
 */
public class TableModel extends BaseModel {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String comment;
	/**
	 * 数据列集合
	 */
	private List<ColumnModel> columns;

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

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

}
