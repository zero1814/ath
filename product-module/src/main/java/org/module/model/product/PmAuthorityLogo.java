package org.module.model.product;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "pm_authority_logo", database = "productmodule", comment = "商品权威标识")
public class PmAuthorityLogo extends BaseModel {

	private static final long serialVersionUID = 1510094876112756957L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "pic_url", isNull = false, comment = "图片链接地址")
	private String picUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}