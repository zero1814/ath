package org.module.dto.system.user;

import org.module.commons.dto.BaseDto;

/**
 * 
 * 类: SmUserRoleDto <br>
 * 描述: 用户角色参数类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:54:50
 */
public class SmUserRoleDto extends BaseDto {

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
