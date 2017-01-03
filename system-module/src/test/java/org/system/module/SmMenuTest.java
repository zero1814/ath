package org.system.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuTest {

	@Autowired
	private ISmMenuService service;

	public void insert() {
		// SmMenu menu = new SmMenu();
		// menu.setCode(CodeHelper.getUniqueCode("SM"));
		// menu.setGroupCode("SM816070848015233024");
		// menu.setName("菜单管理");
		// menu.setCreateUser("admin");
		// service.insertSelective(menu);
		// SmMenu group = new SmMenu();
		// group.setCode(CodeHelper.getUniqueCode("SM"));
		// group.setParentCode("SM816073348684443648");
		// group.setName("菜单组管理");
		// group.setGroupCode("SM816070848015233024");
		// group.setCreateUser("admin");
		// service.insertSelective(group);
		SmMenu menu1 = new SmMenu();
		menu1.setCode(CodeHelper.getUniqueCode("SM"));
		menu1.setParentCode("SM816073348684443648");
		menu1.setName("菜单管理");
		menu1.setGroupCode("SM816070848015233024");
		menu1.setCreateUser("admin");
		service.insertSelective(menu1);
	}

	@Test
	public void update() {
		// SmMenu menu1 = new SmMenu();
		// menu1.setCode("SM816073743460724736");
		// menu1.setParentCode("");
		// menu1.setName("菜单管理01");
		// menu1.setGroupCode("");
		// menu1.setUpdateUser("system");
		// service.updateByCode(menu1);

		service.updateFlagAble("system", "SM816073348684443648", 1);
	}

	public void delete() {
		service.deleteByCode("SM816073743460724736");
	}
}
