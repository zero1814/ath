package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmLesson <br>
 * 描述: 课程表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:43:52
 */
public class EmLesson extends BaseModel {

	/**
	 * 类型编码
	 */
	private String typeCode;

	/**
	 * 教师编码
	 */
	private String teacherCode;

	/**
	 * 开始时间
	 */
	private String startTime;

	/**
	 * 课程时长
	 */
	private Integer length;

	/**
	 * 课程简介
	 */
	private String intro;

	/**
	 * 附件
	 */
	private String adjunct;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
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