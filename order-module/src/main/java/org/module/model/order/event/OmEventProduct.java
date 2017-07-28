package org.module.model.order.event;

import java.math.BigDecimal;

import org.module.annotation.db.Column;
import org.module.annotation.db.Table;
import org.module.model.BaseModel;

@Table(name = "om_event_product", database = "ordermodule", comment = "活动商品")
public class OmEventProduct extends BaseModel {

	private static final long serialVersionUID = 5780216179420134587L;

	@Column(name = "event_code", isNull = false, comment = "活动编码")
	private String eventCode;

	@Column(name = "store_code", isNull = false, comment = "店铺编码")
	private String storeCode;

	@Column(name = "product_code", isNull = false, comment = "商品编码")
	private String productCode;

	@Column(name = "product_url", isNull = false, comment = "活动商品链接地址")
	private String productUrl;

	@Column(name = "sku_code", isNull = false, comment = "商品sku编码")
	private String skuCode;

	@Column(name = "sku_pic_url", isNull = false, comment = "活动商品sku图片链接地址")
	private String skuPicUrl;

	@Column(name = "event_price", isNull = false, comment = "活动价格")
	private BigDecimal eventPrice;

	@Column(name = "event_sku_num", defaultValue = "0", comment = "活动库存")
	private Integer eventSkuNum;

	@Column(name = "sort", isNull = false, comment = "显示排序")
	private Integer sort;

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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuPicUrl() {
		return skuPicUrl;
	}

	public void setSkuPicUrl(String skuPicUrl) {
		this.skuPicUrl = skuPicUrl;
	}

	public BigDecimal getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(BigDecimal eventPrice) {
		this.eventPrice = eventPrice;
	}

	public Integer getEventSkuNum() {
		return eventSkuNum;
	}

	public void setEventSkuNum(Integer eventSkuNum) {
		this.eventSkuNum = eventSkuNum;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}