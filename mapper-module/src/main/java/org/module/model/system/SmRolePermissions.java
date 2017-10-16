package org.module.model.system;

import org.module.model.BaseModel;

/**
 * 
 * 类: SmRolePermissions <br>
 * 描述: 角色权限表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:10:22
 */
public class SmRolePermissions extends BaseModel {

	private static final long serialVersionUID = -922036811829527709L;

	/**
	 * 角色编码
	 */
	private String roleCode;

	/**
	 * 页面编码
	 */
	private String pageCode;

	/**
	 * 页面权限编码
	 */
	private String pagePermissions;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getPagePermissions() {
		return pagePermissions;
	}

	public void setPagePermissions(String pagePermissions) {
		this.pagePermissions = pagePermissions;
	}

}