package org.module.model.system;

import org.module.model.BaseModel;
/**
 * 
 * 类: SmMenu <br>
 * 描述: 菜单维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:07:25
 */
public class SmMenu extends BaseModel {

	private static final long serialVersionUID = 7041812287357425606L;

	/**
	 * 父级编码
	 */
	private String parentCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 页面编码
	 */
	private String pageCode;

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

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}