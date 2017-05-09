package org.module.system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.util.MD5Util;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmUserTest {

	@Autowired
	private ISmUserService service;

	public void insert() {
		SmUser entity = new SmUser();
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		entity.setUserName("admin");
		entity.setPassword(MD5Util.md5Hex("password"));
		entity.setRealName("张三");
		entity.setStatus("0");
		entity.setCreateUser("system");
		service.insertSelective(entity);
	}

	@Test
	public void login() {
		String username = "admin";
		String password = "password";
		service.login(username, password);
	}
}
