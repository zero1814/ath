package org.module.shiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.util.MD5Util;
import org.module.model.system.user.SmUser;
import org.module.shiro.token.manager.TokenManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml",
		"classpath:spring/spring-redis.xml", "classpath:spring/spring-shiro.xml" })
public class ShiroDemo {

	@Test
	public void shiro(){
		SmUser user = new SmUser();
		user.setUserName("test");
		user.setPassword(MD5Util.md5Hex("123456"));
		TokenManager.login(user, false);
	}
}
