package org.module.model.order.order;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_order_detail", database = "ordermodule", comment = "订单详情表")
public class OmOrderEvaluation extends BaseModel {

	private static final long serialVersionUID = -4923315809908223704L;

	@Column(name = "order_code", isNull = false, comment = "订单编码")
	private String orderCode;

	@Column(name = "product_code", isNull = false, comment = "商品编码")
	private String productCode;

	@Column(name = "sku_code", isNull = false, comment = "商品SKU编码")
	private String skuCode;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "evaluate_type", isNull = false, comment = "评价类型")
	private String evaluateType;

	@Column(name = "evaluate_score", isNull = false, comment = "评价分数")
	private Integer evaluateScore;

	@Column(name = "evaluate_content", isNull = false, comment = "评价内容")
	private String evaluateContent;

	@Column(name = "evaluate_pic", isNull = false, comment = "评价上传图片数组")
	private String evaluatePic;

	public String getEvaluatePic() {
		return evaluatePic;
	}

	public void setEvaluatePic(String evaluatePic) {
		this.evaluatePic = evaluatePic;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getEvaluateType() {
		return evaluateType;
	}

	public void setEvaluateType(String evaluateType) {
		this.evaluateType = evaluateType;
	}

	public Integer getEvaluateScore() {
		return evaluateScore;
	}

	public void setEvaluateScore(Integer evaluateScore) {
		this.evaluateScore = evaluateScore;
	}

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

}