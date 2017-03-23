package org.module.model.education;

import org.module.model.BaseModel;

/**
 * 
 * 类: EmLessonExtend <br>
 * 描述: 课程扩展表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月23日 下午5:45:40
 */
public class EmLessonExtend extends BaseModel {

	/**
	 * 视频播放地址
	 */
	private String videoUrl;

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

}