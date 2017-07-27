package org.module.model.product;

import java.math.BigDecimal;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.annotation.mapper.obj.Attribute;
import org.module.model.BaseModel;
import org.module.model.user.UmStoreInfo;

@Table(name = "pm_product_info", database = "productmodule", comment = "商品表")
public class PmProductInfo extends BaseModel {

	private static final long serialVersionUID = -3575298339104513581L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "product_type", isNull = false, comment = "商品类型")
	private String productType;

	@Column(name = "product_status", isNull = false, comment = "商品状态")
	private String productStatus;

	@Column(name = "cost_price", defaultValue = "0.00", comment = "成本价")
	private BigDecimal costPrice;

	@Column(name = "min_sell_price", defaultValue = "0.00", comment = "销售价格最小")
	private BigDecimal minSellPrice;

	@Column(name = "max_sell_price", defaultValue = "0.00", comment = "销售价格最大")
	private BigDecimal maxSellPrice;

	@Column(name = "product_url", isNull = false, comment = "商品链接地址")
	private String productUrl;

	@Column(name = "product_pic", isNull = false, comment = "商品图片")
	private String productPic;

	@Column(name = "product_label", comment = "商品标签,数组存储")
	private String productLabel;

	@Column(name = "product_specification", comment = "商品规格")
	private String productSpecification;

	@Attribute(name = "store", description = "店铺")
	private UmStoreInfo store;

	public String getName() {
		return name;
	}

	public UmStoreInfo getStore() {
		return store;
	}

	public void setStore(UmStoreInfo store) {
		this.store = store;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getMinSellPrice() {
		return minSellPrice;
	}

	public void setMinSellPrice(BigDecimal minSellPrice) {
		this.minSellPrice = minSellPrice;
	}

	public BigDecimal getMaxSellPrice() {
		return maxSellPrice;
	}

	public void setMaxSellPrice(BigDecimal maxSellPrice) {
		this.maxSellPrice = maxSellPrice;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public void setProductLabel(String productLabel) {
		this.productLabel = productLabel;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

}