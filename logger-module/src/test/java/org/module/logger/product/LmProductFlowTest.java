package org.module.logger.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.logger.product.LmProductFlow;
import org.module.result.DataResult;
import org.module.service.logger.product.ILmProductFlowService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmProductFlowTest {

	@Autowired
	private ILmProductFlowService service;

	@Test
	public void insert() {
		LmProductFlow entity = new LmProductFlow();
		entity.setProductCode("12313");
		entity.setFlowStatus("111");
		entity.setProductJson("111");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	@Test
	public void sel() {
		DataResult result = service.selectByProductCode("12313");
		System.out.println(JSON.toJSON(result));
	}

}
