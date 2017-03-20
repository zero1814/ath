package org.module.model.education;

import org.module.model.BaseModel;

public class EmLesson extends BaseModel {

	private String teacherCode;

	private String classesCode;

	private String intro;

	private String adjunct;

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getClassesCode() {
		return classesCode;
	}

	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAdjunct() {
		return adjunct;
	}

	public void setAdjunct(String adjunct) {
		this.adjunct = adjunct;
	}

}