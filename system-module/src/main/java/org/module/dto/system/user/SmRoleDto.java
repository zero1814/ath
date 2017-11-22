package org.module.dto.system.user;

import org.module.commons.dto.BaseDto;

/**
 * 
 * 类: SmRoleDto <br>
 * 描述: 角色参数类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:54:33
 */
public class SmRoleDto extends BaseDto {

	private String code;

	private String name;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
