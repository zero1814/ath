package org.module.model.logger.event;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

/**
 * 
 * 类: LmEventFlow <br>
 * 描述: 活动审核日志 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月20日 上午11:01:06
 */
@Table(name = "lm_event_flow", database = "loggermodule", comment = "活动审核日志")
public class LmEventFlow extends BaseModel {

	private static final long serialVersionUID = 1208668345465206585L;

	@Column(name = "event_code", isNull = false, comment = "活动编码")
	private String eventCode;

	@Column(name = "event_json", isNull = false, comment = "活动详情")
	private String eventJson;

	@Column(name = "flow_status", isNull = false, comment = "活动状态")
	private String flowStatus;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventJson() {
		return eventJson;
	}

	public void setEventJson(String eventJson) {
		this.eventJson = eventJson;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

}