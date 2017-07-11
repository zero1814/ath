package org.module.model.system.db;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_table", database = "systemmodule", comment = "数据表维护表")
public class SmTable extends BaseModel {

	private static final long serialVersionUID = 4854742401861559431L;

	@Column(name = "db_name", isNull = false, comment = "数据库编码名称")
	private String dbName;

	@Column(name = "name", isNull = false, comment = "数据表名称")
	private String name;

	@Column(name = "remark", comment = "备注")
	private String remark;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}