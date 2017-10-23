package org.module.model.system.user;

import org.module.base.model.BaseModel;

/**
 * 
 * 类: SmRole <br>
 * 描述: 角色表 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午10:17:21
 */
public class SmRole extends BaseModel {

	private static final long serialVersionUID = 2321040175531681908L;

	private String name;

	private String enName;

	private String status;

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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