package org.module.model.logger.order;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "lm_order_return", database = "loggermodule", comment = "退换货日志")
public class LmOrderReturn extends BaseModel {

	private static final long serialVersionUID = -7813212671968748066L;

	@Column(name = "order_code", isNull = false, comment = "订单编码")
	private String orderCode;

	@Column(name = "return_code", isNull = false, comment = "退换货编码")
	private String returnCode;

	@Column(name = "status", isNull = false, comment = "状态")
	private String status;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}