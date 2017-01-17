package org.system.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuTest {

	@Autowired
	private ISmMenuService service;

	@Test
	public void insert() {
		
	}

	public void update() {
		SmMenu menu1 = new SmMenu();
		menu1.setCode("SM816073743460724736");
		menu1.setParentCode("");
		menu1.setName("菜单管理01");
		menu1.setGroupCode("");
		menu1.setUpdateUser("system");
		service.updateByCode(menu1);
	}

	public void delete() {
		service.deleteByCode("SM816073743460724736");
	}

	public void findDataAll() {
		DataResult result = service.findDataAll(new SmMenuDto());
		System.out.println(result.getData().size());
	}
}
