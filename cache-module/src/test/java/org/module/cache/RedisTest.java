package org.module.cache;

import org.cache.helper.RedisStringHelper;
import org.commons.base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-redis.xml" })
public class RedisTest extends BaseTest {

	@Test
	public void set() {
		RedisStringHelper.instance().set("address", "address");
	}
}
