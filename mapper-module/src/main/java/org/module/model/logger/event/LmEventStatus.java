package org.module.model.logger.event;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

/**
 * 
 * 类: LmEventStatus <br>
 * 描述: 活动状态变更日志 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月20日 上午11:03:07
 */
@Table(name = "lm_event_status", database = "loggermodule", comment = "活动状态变更日志")
public class LmEventStatus extends BaseModel {

	private static final long serialVersionUID = 2802140849810269497L;

	@Column(name = "event_code", isNull = false, comment = "活动编码")
	private String eventCode;

	@Column(name = "before_status", isNull = false, comment = "活动之前状态")
	private String beforeStatus;
	@Column(name = "current_status", isNull = false, comment = "活动当前状态")
	private String currentStatus;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getBeforeStatus() {
		return beforeStatus;
	}

	public void setBeforeStatus(String beforeStatus) {
		this.beforeStatus = beforeStatus;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

}