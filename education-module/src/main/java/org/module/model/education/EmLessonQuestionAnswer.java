package org.module.model.education;

import org.module.model.BaseModel;

public class EmLessonQuestionAnswer extends BaseModel {

	private String questionCode;

	private String answer;

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
}