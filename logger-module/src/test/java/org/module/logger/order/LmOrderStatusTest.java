package org.module.logger.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.logger.order.LmOrderStatus;
import org.module.result.DataResult;
import org.module.service.logger.order.ILmOrderStatusService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmOrderStatusTest {

	@Autowired
	private ILmOrderStatusService service;

	@Test
	public void insert() {
		LmOrderStatus entity = new LmOrderStatus();
		entity.setOrderCode("1123");
		entity.setCurrentStatus("1");
		entity.setNextStatus("2");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	@Test
	public void sel() {
		DataResult result = service.selectByOrderCode("1123");
		System.out.println(JSON.toJSON(result));
	}
}
