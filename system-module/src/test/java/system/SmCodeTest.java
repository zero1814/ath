package system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.service.system.ISmCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmCodeTest {

	@Autowired
	private ISmCodeService service;
	
	@Test
	public void getCode() {
		System.out.println(service.getCode("TEST"));
	}
}
