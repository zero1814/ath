package cn.com.cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.service.cms.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class IndexTest {

	@Autowired
	private IndexService service;
	@Test
	public void propVal(){
		service.initMenus();
	}
}
