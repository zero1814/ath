package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmClass <br>
 * 描述: 班级 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月20日 下午4:51:23
 */
public class EmClass extends BaseModel {

	private String parentCode;

	private String name;

	private String schoolCode;

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

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

}