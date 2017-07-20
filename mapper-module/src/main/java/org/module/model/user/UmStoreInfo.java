package org.module.model.user;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "um_store_info", database = "usermodule", comment = "店铺表")
public class UmStoreInfo extends BaseModel {

	private static final long serialVersionUID = 7165972358092534846L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "store_url", isNull = false, comment = "店铺首页链接地址")
	private String storeUrl;

	@Column(name = "store_pic_url", isNull = false, comment = "店铺图片链接地址")
	private String storePicUrl;

	@Column(name = "status", isNull = false, comment = "状态")
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public String getStorePicUrl() {
		return storePicUrl;
	}

	public void setStorePicUrl(String storePicUrl) {
		this.storePicUrl = storePicUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}