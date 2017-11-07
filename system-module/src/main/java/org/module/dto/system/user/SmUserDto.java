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

	private String vertifyCode;

	private String realName;
	
	private String phone;
	
	private String status;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVertifyCode() {
		return vertifyCode;
	}

	public void setVertifyCode(String vertifyCode) {
		this.vertifyCode = vertifyCode;
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

}
