package org.module.model.logger.product;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "lm_product_flow", database = "loggermodule", comment = "商品审核日志")
public class LmProductFlow extends BaseModel {

	private static final long serialVersionUID = -7188919548608129387L;

	@Column(name = "product_code", isNull = false, comment = "商品编码")
	private String productCode;

	@Column(name = "flow_status", isNull = false, comment = "审批状态")
	private String flowStatus;

	@Column(name = "product_json", isNull = false, comment = "审批时的商品信息")
	private String productJson;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public String getProductJson() {
		return productJson;
	}

	public void setProductJson(String productJson) {
		this.productJson = productJson;
	}

}