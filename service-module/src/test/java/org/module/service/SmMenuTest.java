package org.module.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.result.EntityResult;
import org.module.service.system.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mapper.xml", "classpath:spring/spring-service.xml" })
public class SmMenuTest {

	@Autowired
	private ISmMenuService service;

	@Test
	public void selCode() {
		EntityResult result = service.selectByCode("SM919878991635017728");
		System.out.println(JSON.toJSON(result));
	}
}
