package org.module.model.education;

import org.module.model.BaseModel;

public class EmLessonQuestion extends BaseModel {

	private String lessonCode;

	private Integer flagSolve;

	private String question;

	public String getLessonCode() {
		return lessonCode;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public Integer getFlagSolve() {
		return flagSolve;
	}

	public void setFlagSolve(Integer flagSolve) {
		this.flagSolve = flagSolve;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}