package org.module.model.system.db;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "sm_database", database = "systemmodule", comment = "数据库维护表")
public class SmDatabase extends BaseModel {

	private static final long serialVersionUID = 9083228086220244225L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "driver", isNull = false, comment = "驱动")
	private String driver;

	@Column(name = "url", isNull = false, comment = "链接地址")
	private String url;

	@Column(name = "user_name", comment = "密码")
	private String userName;

	@Column(name = "password", isNull = false, comment = "名称")
	private String password;

	@Column(name = "remark", comment = "备注")
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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