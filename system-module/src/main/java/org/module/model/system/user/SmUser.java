package org.module.model.system.user;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Table(database = "systemmodule", name = "sm_user", comment = "用户表")
@Object(name = "系统用户", description = "管理系统用户表")
public class SmUser extends BaseModel {

	@Column(name = "user_name", comment = "用户名")
	@Attribute(name = "userName", description = "用户名")
	private String userName;

	@Column(name = "password", comment = "密码")
	@Attribute(name = "password", description = "密码")
	private String password;

	@Column(name = "real_name", comment = "真实姓名")
	@Attribute(name = "realName", description = "真实姓名")
	private String realName;

	@Column(name = "type_code", comment = "用户类型")
	@Attribute(name = "typeCode", description = "用户类型")
	private String typeCode;

	@Attribute(name = "typeName", description = "用户类型名称")
	private String typeName;

	@Column(name = "status", comment = "状态")
	@Attribute(name = "status", description = "状态")
	private String status;

	@Attribute(name = "role", description = "用户角色")
	private SmUserRole role;

	public SmUserRole getRole() {
		return role;
	}

	public void setRole(SmUserRole role) {
		this.role = role;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}