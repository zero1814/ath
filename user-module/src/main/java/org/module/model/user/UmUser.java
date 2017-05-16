package org.module.model.user;

import org.module.commons.annotation.obj.Attribute;
import org.module.model.BaseModel;

/**
 * 
 * 类: UmUser <br>
 * 描述: 用户表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月15日 上午9:21:33
 */
public class UmUser extends BaseModel {

	/**
	 * 部门编码
	 */
	@Attribute(isNull = false, comment = "请选择部门", name = "部门编码")
	private String departmentCode;

	/**
	 * 用户名
	 */
	@Attribute(isNull = false, comment = "用户名不能为空", name = "用户名")
	private String userName;

	/**
	 * 密码
	 */
	@Attribute(isNull = false, comment = "密码不能为空", name = "密码")
	private String password;

	/**
	 * 真实姓名
	 */
	@Attribute(isNull = false, comment = "请填写真实姓名", name = "真实姓名")
	private String realName;

	/**
	 * 状态
	 */
	@Attribute(isNull = false, comment = "用户状态不能为空", name = "真实姓名")
	private String status;

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}