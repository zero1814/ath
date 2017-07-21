package org.module.logger.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.logger.event.LmEventFlow;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.service.logger.event.ILmEventFlowService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmEventFlowTest {

	@Autowired
	private ILmEventFlowService service;

	@Test
	public void insert() {
		LmEventFlow entity = new LmEventFlow();
		entity.setEventCode("1111");
		entity.setEventJson("sdfsfsdfsdfsfd");
		entity.setFlowStatus("122");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		EntityResult result = service.insertSelective(entity);
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void selectByEventCode() {
		DataResult result = service.selectByEventCode("1111");
		System.out.println(JSON.toJSON(result));
	}
}
