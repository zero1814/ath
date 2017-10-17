package org.module.model.system.db;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.base.model.BaseModel;

@Table(name = "sm_database", database = "systemmodule", comment = "数据库维护表")
public class SmDatabase extends BaseModel {

	private static final long serialVersionUID = -5343056862098669105L;

	@Column(name = "db_code",  isNull=false,comment = "数据库编码")
	private String dbCode;

	@Column(name = "db_name", isNull=false, comment = "数据库名称")
	private String dbName;

	@Column(name = "driver", isNull=false, comment = "驱动")
	private String driver;

	@Column(name = "url", isNull=false, comment = "链接地址")
	private String url;

	@Column(name = "user_name", isNull=false, comment = "用户名")
	private String userName;

	@Column(name = "password", comment = "密码")
	private String password;

	@Column(name = "remark", comment = "备注")
	private String remark;

	public String getDbCode() {
		return dbCode;
	}

	public void setDbCode(String dbCode) {
		this.dbCode = dbCode;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}