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
		/**
		 * SM821236787828486144 商品相关<br>
		 * SM821236790252793856 订单相关<br>
		 * SM821236790433148928 用户相关 <br>
		 * SM821236790793859072 数据相关<br>
		 * SM821236791355895808 审批相关<br>
		 * SM821236792240893952 系统相关<br>
		 */
		SmMenu menu1 = new SmMenu();
		menu1.setCode(CodeHelper.getUniqueCode("SM"));
		menu1.setGroupCode("SM821236792240893952");
		menu1.setName("菜单管理");
		menu1.setCreateUser("admin");
		service.insertSelective(menu1);
		SmMenu menu2 = new SmMenu();
		menu2.setCode(CodeHelper.getUniqueCode("SM"));
		menu2.setParentCode(menu1.getCode());
		menu2.setGroupCode("SM821236792240893952");
		menu2.setName("菜单组管理");
		menu2.setCreateUser("admin");
		service.insertSelective(menu2);
		SmMenu menu3 = new SmMenu();
		menu3.setCode(CodeHelper.getUniqueCode("SM"));
		menu3.setParentCode(menu1.getCode());
		menu3.setGroupCode("SM821236792240893952");
		menu3.setName("菜单管理");
		menu3.setCreateUser("admin");
		service.insertSelective(menu3);
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
