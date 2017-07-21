package org.module.logger.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.logger.store.LmStoreFlow;
import org.module.result.DataResult;
import org.module.service.logger.store.ILmStoreFlowService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmStoreFlowTest {

	@Autowired
	private ILmStoreFlowService service;

	@Test
	public void insert() {
		LmStoreFlow entity = new LmStoreFlow();
		entity.setStoreCode("1111");
		entity.setFlowStatus("sddddd");
		entity.setStoreJson("1111");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	@Test
	public void sel() {
		DataResult result = service.selectByStoreCode("1111");
		System.out.println(JSON.toJSON(result));
	}
}
