package org.module.log;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.util.DateUtil;
import org.module.mapper.log.user.LmLoginMapper;
import org.module.model.log.user.LmLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class LmLoginTest {

	@Autowired
	private LmLoginMapper mapper;

	@Test
	public void insert() {
		LmLogin entity = new LmLogin();
		entity.setUid(UUID.randomUUID().toString().replace("-", ""));
		entity.setUserCode("123");
		entity.setIp("123");
		entity.setLoginTime(DateUtil.getSysDateTime());
		mapper.insertSelective(entity);
	}
}
