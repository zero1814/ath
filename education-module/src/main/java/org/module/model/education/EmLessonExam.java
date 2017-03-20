package org.module.model.education;

import org.module.model.BaseModel;

public class EmLessonExam extends BaseModel {

	private String lessonCode;

	private String examCode;

	public String getLessonCode() {
		return lessonCode;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

}