package org.module.model.system.user;

import org.module.commons.model.BaseModel;

/**
 * 
 * 类: SmUserRole <br>
 * 描述: 用户角色表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午10:17:39
 */
public class SmUserRole extends BaseModel {

	private static final long serialVersionUID = -8811826142253574416L;

	private String userCode;

	private String roleCode;

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