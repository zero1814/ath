package org.module.model.order.order;

import java.math.BigDecimal;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_order_detail", database = "ordermodule", comment = "订单详情表")
public class OmOrderDetail extends BaseModel {

	private static final long serialVersionUID = 6517466916781087830L;

	@Column(name = "order_code", isNull = false, comment = "订单编码")
	private String orderCode;

	@Column(name = "sku_code", isNull = false, comment = "商品sku编码")
	private String skuCode;

	@Column(name = "product_code", isNull = false, comment = "商品编码")
	private String productCode;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "cost_price", isNull = false, comment = "成本价")
	private BigDecimal costPrice;

	@Column(name = "sell_price", isNull = false, comment = "销售价")
	private BigDecimal sellPrice;

	@Column(name = "sku_num", isNull = false, comment = "sku销售数量")
	private Integer skuNum;

	@Column(name = "coupon_price", isNull = false, comment = "优惠券优惠金额")
	private BigDecimal couponPrice;

	@Column(name = "show_price", isNull = false, comment = "显示金额")
	private BigDecimal showPrice;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getSkuNum() {
		return skuNum;
	}

	public void setSkuNum(Integer skuNum) {
		this.skuNum = skuNum;
	}

	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	public BigDecimal getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(BigDecimal showPrice) {
		this.showPrice = showPrice;
	}

}