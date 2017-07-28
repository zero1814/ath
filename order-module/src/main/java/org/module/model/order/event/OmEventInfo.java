package org.module.model.order.event;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_event_info", database = "ordermodule", comment = "活动")
public class OmEventInfo extends BaseModel {

	private static final long serialVersionUID = 2054142573823342533L;

	@Column(name = "name", isNull = false, comment = "活动标题")
	private String name;

	@Column(name = "event_type", isNull = false, comment = "活动类型")
	private String eventType;

	@Column(name = "description", isNull = false, comment = "活动描述")
	private String description;

	@Column(name = "start_time", isNull = false, comment = "开始时间")
	private String startTime;

	@Column(name = "end_time", isNull = false, comment = "结束时间")
	private String endTime;

	@Column(name = "event_status", isNull = false, comment = "活动状态")
	private String eventStatus;

	@Column(name = "event_pic_url", isNull = false, comment = "活动图片链接地址")
	private String eventPicUrl;

	@Column(name = "event_url", isNull = false, comment = "活动链接地址")
	private String eventUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getEventPicUrl() {
		return eventPicUrl;
	}

	public void setEventPicUrl(String eventPicUrl) {
		this.eventPicUrl = eventPicUrl;
	}

	public String getEventUrl() {
		return eventUrl;
	}

	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

}