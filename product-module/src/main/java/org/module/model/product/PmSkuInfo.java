package org.module.model.product;

import java.math.BigDecimal;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "pm_sku_info", database = "productmodule", comment = "商品sku表")
public class PmSkuInfo extends BaseModel {

	private static final long serialVersionUID = 3144796410026448383L;

	@Column(name = "name", isNull = false, comment = "名称")
	private String name;

	@Column(name = "product_code", isNull = false, comment = "商品编码")
	private String productCode;

	@Column(name = "cost_price", defaultValue = "0.00", comment = "成本价")
	private BigDecimal costPrice;

	@Column(name = "market_price", defaultValue = "0.00", comment = "市场价")
	private BigDecimal marketPrice;

	@Column(name = "sell_price", defaultValue = "0.00", comment = "销售价")
	private BigDecimal sellPrice;

	@Column(name = "stock_num", defaultValue = "0", comment = "库存数")
	private Integer stockNum;

	@Column(name = "security_stock_num", isNull = false, comment = "安全库存")
	private Integer securityStockNum;

	@Column(name = "sku_pic_url", comment = "产品图片")
	private String skuPicUrl;

	@Column(name = "status", isNull = false, comment = "sku状态")
	private String status;

	@Column(name = "mini_order", isNull = false, comment = "名称")
	private Integer miniOrder;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public Integer getSecurityStockNum() {
		return securityStockNum;
	}

	public void setSecurityStockNum(Integer securityStockNum) {
		this.securityStockNum = securityStockNum;
	}

	public String getSkuPicUrl() {
		return skuPicUrl;
	}

	public void setSkuPicUrl(String skuPicUrl) {
		this.skuPicUrl = skuPicUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMiniOrder() {
		return miniOrder;
	}

	public void setMiniOrder(Integer miniOrder) {
		this.miniOrder = miniOrder;
	}

}