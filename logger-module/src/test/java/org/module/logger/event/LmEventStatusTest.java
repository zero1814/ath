package org.module.logger.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.logger.event.LmEventStatus;
import org.module.result.DataResult;
import org.module.service.logger.event.ILmEventStatusService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmEventStatusTest {
	@Autowired
	private ILmEventStatusService service;

	@Test
	public void insert() {
		LmEventStatus entity = new LmEventStatus();
		entity.setEventCode("111");
		entity.setBeforeStatus("12312");
		entity.setCurrentStatus("22222");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	@Test
	public void sel() {
		DataResult result = service.selectByEventCode("111");
		System.out.println(JSON.toJSON(result));
	}
}
