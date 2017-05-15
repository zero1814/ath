package org.module.model.user;

import org.module.model.BaseModel;

/**
 * 
 * 类: UmCompany <br>
 * 描述: 公司表 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月15日 上午9:20:37
 */
public class UmCompany extends BaseModel {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 负责人
	 */
	private String principal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

}