package org.module.model.logger.order;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "lm_order_status", database = "loggermodule", comment = "订单状态更新日志")
public class LmOrderStatus extends BaseModel {

	private static final long serialVersionUID = 8745705052312860077L;

	@Column(name = "order_code", isNull = false, comment = "订单编码")
	private String orderCode;

	@Column(name = "order_json", isNull = false, comment = "订单详情")
	private String orderJson;

	@Column(name = "current_status", isNull = false, comment = "订单当前状态")
	private String currentStatus;

	@Column(name = "next_status", isNull = false, comment = "订单下一阶段状态")
	private String nextStatus;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getNextStatus() {
		return nextStatus;
	}

	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}

	public String getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(String orderJson) {
		this.orderJson = orderJson;
	}

}