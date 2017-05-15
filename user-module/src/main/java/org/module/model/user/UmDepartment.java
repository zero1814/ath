package org.module.model.user;

import org.module.model.BaseModel;

/**
 * 
 * 类: UmDepartment <br>
 * 描述: 部门表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月15日 上午9:21:03
 */
public class UmDepartment extends BaseModel {

	/**
	 * 公司编码
	 */
	private String companyCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 负责人
	 */
	private String principal;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

}