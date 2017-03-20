package org.module.model.education;

import org.module.model.BaseModel;

public class EmQuestionBank extends BaseModel {

	private String typeCode;

	private String question;

	private String questionOptions;

	private String answer;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(String questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}