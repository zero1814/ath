package org.module.model.user;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "um_user_address", database = "usermodule", comment = "用户地址管理")
public class UmUserAddress extends BaseModel {

	private static final long serialVersionUID = -3502405558932261188L;

	@Column(name = "user_code", isNull = false, comment = "用户编码")
	private String userCode;

	@Column(name = "province_city", isNull = false, comment = "省市")
	private String provinceCity;

	@Column(name = "area", isNull = false, comment = "地区")
	private String area;

	@Column(name = "address", isNull = false, comment = "详细地址")
	private String address;

	@Column(name = "status", isNull = false, comment = "状态")
	private String status;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getProvinceCity() {
		return provinceCity;
	}

	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}