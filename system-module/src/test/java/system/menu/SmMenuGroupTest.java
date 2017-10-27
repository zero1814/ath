package system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.system.menu.ISmMenuGroupService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuGroupTest {

	@Autowired
	private ISmMenuGroupService service;

	@Test
	public void insert() {
		SmMenuGroup entity = new SmMenuGroup();
		entity.setCode(CodeHelper.getCode("SMG"));
		entity.setName("cms");
		entity.setCreateUser("system");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}
}
