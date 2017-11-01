package org.module.dto.system.user;

import org.module.base.dto.BaseDto;

/**
 * 
 * 类: SmUserDto <br>
 * 描述: 用户参数类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:54:42
 */
public class SmUserDto extends BaseDto {

	private String userName;

	private String password;

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

}
