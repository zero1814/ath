package org.module.logger.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.WebHelper;
import org.module.model.logger.user.LmLogin;
import org.module.service.logger.user.ILmLoginService;
import org.module.util.DateUtil;
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
		entity.setUserCode("21111");
		entity.setIp(WebHelper.getIpAddress());
		entity.setLoginTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}
}
