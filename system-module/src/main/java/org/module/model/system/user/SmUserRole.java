package org.module.model.system.user;

import java.util.List;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.annotation.obj.Attribute;
import org.module.base.model.BaseModel;

@Table(name = "sm_user_role", database = "systemmodule", comment = "用户角色关系表")
public class SmUserRole extends BaseModel {

	private static final long serialVersionUID = 4094509176481334549L;

	@Column(name = "user_code", isNull = false, comment = "用户编码")
	private String userCode;

	@Column(name = "role_code", isNull = false, comment = "角色编码")
	private String roleCode;

	@Attribute(name = "user", description = "用户信息")
	private SmUser user;

	@Attribute(name = "roles", description = "用户角色列表")
	private List<SmRole> roles;

	/**
	 * 角色
	 */
	@Attribute(name = "role", description = "角色")
	private SmRole role;

	public SmRole getRole() {
		return role;
	}

	public void setRole(SmRole role) {
		this.role = role;
	}

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

}