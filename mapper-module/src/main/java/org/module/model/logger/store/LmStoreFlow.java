package org.module.model.logger.store;

import org.module.model.BaseModel;

public class LmStoreFlow extends BaseModel{

	private static final long serialVersionUID = -1118513273208645197L;

	private String storeCode;

	private String flowStatus;

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
	
	
}