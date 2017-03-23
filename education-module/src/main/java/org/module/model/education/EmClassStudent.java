package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmClassStudent <br>
 * 描述: 班级学生关系表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:42:27
 */
public class EmClassStudent extends BaseModel {

	/**
	 * 班级编码
	 */
	private String classCode;

	/**
	 * 学生编码
	 */
	private String studentCode;

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

}