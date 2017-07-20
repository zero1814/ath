package org.module.model.order.event;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_event_product", database = "ordermodule", comment = "活动")
public class OmEventStore extends BaseModel {

	private static final long serialVersionUID = -6413781527882257808L;

	@Column(name = "event_code", isNull = false, comment = "活动编码")
	private String eventCode;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "is_all", defaultValue = "0", comment = "是否店铺商品全部参与活动，0 否 1 是")
	private Integer isAll;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Integer getIsAll() {
		return isAll;
	}

	public void setIsAll(Integer isAll) {
		this.isAll = isAll;
	}

}