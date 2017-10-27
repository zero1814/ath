package system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.BaseTest;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuTest extends BaseTest{

	@Autowired
	private ISmMenuService service;

	@Test
	public void insert() {
		SmMenu entity = new SmMenu();
//		entity.setCode(codeService.getCode("SM"));
		entity.setName("菜单相关");
		entity.setPageCode("11");
		entity.setGroupCode("ddd");
		entity.setCreateUser("system");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}
}
