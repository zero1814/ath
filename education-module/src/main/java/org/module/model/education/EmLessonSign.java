package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmLessonSign <br>
 * 描述: 课程签到记录 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:45:59
 */
public class EmLessonSign extends BaseModel {

	/**
	 * 课程编码
	 */
	private String lessonCode;

	/**
	 * 学生编码
	 */
	private String studentCode;

	public String getLessonCode() {
		return lessonCode;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

}