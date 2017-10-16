package org.module.model.system;

import org.module.model.BaseModel;
/**
 * 
 * 类: SmPage <br>
 * 描述: 页面维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:09:43
 */
public class SmPage extends BaseModel {

	private static final long serialVersionUID = 8634870166978736551L;

	/**
	 * 父级编码
	 */
	private String parentCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 状态
	 */
	private String status;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}