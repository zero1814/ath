package org.module.commons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.BaseTest;
import org.module.commons.helper.CodeHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class CodeTest extends BaseTest {

	@Test
	public void getCode() {
		System.out.println(CodeHelper.getCode("TEST"));
	}
}
