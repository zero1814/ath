package org.module.model.order.order;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_order_payment", database = "ordermodule", comment = "支付方式管理")
public class OmOrderReturns extends BaseModel {

	private static final long serialVersionUID = -6144908754482014204L;

	@Column(name = "order_code", isNull = false, comment = "订单编码")
	private String orderCode;

	@Column(name = "return_type", isNull = false, comment = "退货类型")
	private String returnType;

	@Column(name = "return_reason", isNull = false, comment = "退货原因")
	private String returnReason;

	@Column(name = "return_status", isNull = false, comment = "退货状态")
	private String returnStatus;

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

}