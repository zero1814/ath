package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmLessonClass <br>
 * 描述: 课程班级关系表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:50:36
 */
public class EmLessonClass extends BaseModel {

	/**
	 * 课程编码
	 */
	private String lessonCode;

	/**
	 * 班级编码
	 */
	private String classCode;

	public String getLessonCode() {
		return lessonCode;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

}