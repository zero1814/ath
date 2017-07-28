package org.module.model.system.db;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_table", database = "systemmodule", comment = "数据表维护表")
public class SmTable extends BaseModel {

	private static final long serialVersionUID = 4768834696479513182L;

	@Column(name = "db_code", isNull=false, comment = "数据库编码")
	private String dbCode;

	@Column(name = "table_code", isNull=false, comment = "数据表编码")
	private String tableCode;

	@Column(name = "table_name", isNull=false, comment = "数据表名称")
	private String tableName;

	@Column(name = "type",defaultValue="table", comment = "数据表类型 table数据表 view视图")
	private String type;

	@Column(name = "remark", comment = "备注")
	private String remark;

	public String getDbCode() {
		return dbCode;
	}

	public void setDbCode(String dbCode) {
		this.dbCode = dbCode;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}