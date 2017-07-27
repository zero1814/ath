package org.module.product;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.product.PmProductInfo;
import org.module.service.product.IPmProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class PmProductInfoTest {

	@Autowired
	private IPmProductInfoService service;

	@Test
	public void insert() {
		PmProductInfo entity = new PmProductInfo();
		entity.setCode(CodeHelper.getUniqueCode("PP"));
		entity.setName("测试商品");
		entity.setProductType("测试");
		entity.setCostPrice(BigDecimal.valueOf(10.21));
		entity.setStoreCode("110011");
		entity.setMinSellPrice(BigDecimal.valueOf(10));
		entity.setMaxSellPrice(BigDecimal.valueOf(100));
		entity.setProductLabel("测试");
		entity.setProductStatus("测试");
		entity.setProductPic("default.jpg");
		entity.setProductSpecification("测试");
		entity.setProductUrl("test.htm");
		entity.setCreateUser("insert");
		service.insertSelective(entity);
	}
}
