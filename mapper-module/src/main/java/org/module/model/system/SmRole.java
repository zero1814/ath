package org.module.model.system;

import org.module.model.BaseModel;
/**
 * 
 * 类: SmRole <br>
 * 描述: 系统角色表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:10:09
 */
public class SmRole extends BaseModel {

	private static final long serialVersionUID = 7923510202103784761L;

	/**
	 * 名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}