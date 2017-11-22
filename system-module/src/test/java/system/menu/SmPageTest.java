package system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.util.DateUtil;
import org.module.model.system.menu.SmPage;
import org.module.service.system.menu.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageTest {

	@Autowired
	private ISmPageService service;

	@Test
	public void insert() {
		SmPage entity = new SmPage();
		entity.setCode(CodeHelper.getCode("SP"));
		entity.setName("菜单管理");
		entity.setCreateUser("system");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}
}
