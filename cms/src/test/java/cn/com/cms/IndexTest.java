package cn.com.cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.map.MStringMap;
import org.module.commons.util.file.prop.PropLoad;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class IndexTest {

	@Test
	public void propVal(){
		MStringMap map = PropLoad.instance().getData("config");
		System.out.println(map);
	}
}
