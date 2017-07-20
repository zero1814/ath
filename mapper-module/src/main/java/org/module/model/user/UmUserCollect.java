package org.module.model.user;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "um_user_collect", database = "usermodule", comment = "用户收藏")
public class UmUserCollect extends BaseModel {

	private static final long serialVersionUID = 2340267670949110288L;

	@Column(name = "user_code", isNull = false, comment = "用户编码")
	private String userCode;

	@Column(name = "collect_type", isNull = false, comment = "收藏类型")
	private String collectType;

	@Column(name = "collect_code", isNull = false, comment = "收藏编码：商品编码 店铺编码")
	private String collectCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCollectType() {
		return collectType;
	}

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	public String getCollectCode() {
		return collectCode;
	}

	public void setCollectCode(String collectCode) {
		this.collectCode = collectCode;
	}

}