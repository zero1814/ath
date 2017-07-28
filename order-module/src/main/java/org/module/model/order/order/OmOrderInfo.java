package org.module.model.order.order;

import java.math.BigDecimal;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_order_info", database = "ordermodule", comment = "订单维护表")
public class OmOrderInfo extends BaseModel {

	private static final long serialVersionUID = 5650928513857946646L;

	@Column(name = "type", isNull = false, comment = "订单类型")
	private String type;

	@Column(name = "pay_type", isNull = false, comment = "支付类型")
	private String payType;

	@Column(name = "status", isNull = false, comment = "订单状态")
	private String status;

	@Column(name = "buyer_code", isNull = false, comment = "买家编码")
	private String buyerCode;

	@Column(name = "order_source", isNull = false, comment = "订单来源")
	private String orderSource;

	@Column(name = "order_money", defaultValue = "0.00", comment = "订单金额")
	private BigDecimal orderMoney;

	@Column(name = "payed_money", defaultValue = "0.00", comment = "实际支付金额")
	private BigDecimal payedMoney;

	@Column(name = "outer_code", isNull = false, comment = "外部订单编码")
	private String outerCode;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "asale_code", comment = "退货单号")
	private String asaleCode;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBuyerCode() {
		return buyerCode;
	}

	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public BigDecimal getPayedMoney() {
		return payedMoney;
	}

	public void setPayedMoney(BigDecimal payedMoney) {
		this.payedMoney = payedMoney;
	}

	public String getOuterCode() {
		return outerCode;
	}

	public void setOuterCode(String outerCode) {
		this.outerCode = outerCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getAsaleCode() {
		return asaleCode;
	}

	public void setAsaleCode(String asaleCode) {
		this.asaleCode = asaleCode;
	}

}