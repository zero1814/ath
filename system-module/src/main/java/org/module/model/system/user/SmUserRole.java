package org.module.model.system.user;

import java.util.List;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;
import org.module.model.system.role.SmRole;

@Table(database = "systemmodule", name = "sm_user_role", comment = "用户角色关系表")
@Object(name = "用户角色关系表", description = "管理系统用户与角色的关系")
public class SmUserRole extends BaseModel {

	@Column(name = "user_code", comment = "用户编码")
	@Attribute(name = "userCode", description = "用户编码")
	private String userCode;

	@Column(name = "role_code", comment = "角色编码")
	@Attribute(name = "roleCode", description = "角色编码")
	private String roleCode;

	@Attribute(name = "role", description = "用户对应角色结果集")
	private List<SmRole> role;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<SmRole> getRole() {
		return role;
	}

	public void setRole(List<SmRole> role) {
		this.role = role;
	}

}