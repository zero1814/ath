package org.module.model.order.order;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_order_payment", database = "ordermodule", comment = "支付方式管理")
public class OmOrderPayment extends BaseModel {

	private static final long serialVersionUID = 8369164888072247782L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "gateway", isNull = false, comment = "支付网关")
	private String gateway;

	@Column(name = "status", isNull = false, comment = "状态")
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}