package org.module.model.logger.store;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "lm_store_flow", database = "loggermodule", comment = "店铺审核日志")
public class LmStoreFlow extends BaseModel {

	private static final long serialVersionUID = -1118513273208645197L;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "flow_status", isNull = false, comment = "审核状态")
	private String flowStatus;

	@Column(name = "store_json", isNull = false, comment = "店铺信息")
	private String storeJson;

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public String getStoreJson() {
		return storeJson;
	}

	public void setStoreJson(String storeJson) {
		this.storeJson = storeJson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}