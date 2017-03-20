package org.module.model.education;

import org.module.model.BaseModel;

public class EmTeacherCourse extends BaseModel {

	private String teacherCode;

	private String courseCode;

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}