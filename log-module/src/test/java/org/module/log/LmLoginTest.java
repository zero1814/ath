package org.module.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.util.DateUtil;
import org.module.model.log.user.LmLogin;
import org.module.service.log.ILmLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmLoginTest {

	@Autowired
	private ILmLoginService service;

	@Test
	public void insert() {
		LmLogin entity = new LmLogin();
		entity.setUserCode("test");
		entity.setIp("123");
		entity.setLoginTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

}
