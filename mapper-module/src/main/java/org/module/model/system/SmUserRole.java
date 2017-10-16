package org.module.model.system;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmUserRole <br>
 * 描述: 用户角色关系表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:10:33
 */
public class SmUserRole extends BaseModel {

	private static final long serialVersionUID = 8498207547797400860L;

	/**
	 * 用户编码
	 */
	private String userCode;

	/**
	 * 角色编码
	 */
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