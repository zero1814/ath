package org.module.system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuTest {

	@Autowired
	private ISmMenuService service;

	@Test
	public void insert() {
		SmMenu entity = new SmMenu();
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setCreateUser("system");
		entity.setName("菜单管理");
		entity.setGroupCode("SM832935300341690368");
		service.insertSelective(entity);
		SmMenu entity1 = new SmMenu();
		entity1.setCode(CodeHelper.getUniqueCode("SM"));
		entity1.setParentCode(entity.getCode());
		entity1.setCreateUser("system");
		entity1.setName("菜单组管理");
		entity1.setUrl("system/menugroup/index.htm");
		entity1.setGroupCode("SM832935300341690368");
		service.insertSelective(entity1);
		SmMenu entity2 = new SmMenu();
		entity2.setCode(CodeHelper.getUniqueCode("SM"));
		entity2.setParentCode(entity.getCode());
		entity2.setCreateUser("system");
		entity2.setName("菜单管理");
		entity2.setUrl("system/menu/index.htm");
		entity2.setGroupCode("SM832935300341690368");
		service.insertSelective(entity2);
		SmMenu entity3 = new SmMenu();
		entity3.setCode(CodeHelper.getUniqueCode("SM"));
		entity3.setCreateUser("system");
		entity3.setName("角色管理");
		entity3.setGroupCode("SM832935300341690368");
		service.insertSelective(entity3);
		SmMenu entity4 = new SmMenu();
		entity4.setCode(CodeHelper.getUniqueCode("SM"));
		entity4.setParentCode(entity3.getCode());
		entity4.setCreateUser("system");
		entity4.setName("角色管理");
		entity4.setGroupCode("SM832935300341690368");
		service.insertSelective(entity4);
		SmMenu entity5 = new SmMenu();
		entity5.setCode(CodeHelper.getUniqueCode("SM"));
		entity5.setParentCode(entity3.getCode());
		entity5.setCreateUser("system");
		entity5.setName("权限设置");
		entity5.setGroupCode("SM832935300341690368");
		service.insertSelective(entity5);
	}

	public void edit() {
		SmMenu entity = new SmMenu();
		entity.setCode("SM828896784997675008");
		entity.setUpdateUser("admin");
		entity.setName("菜单管理-改");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult result = service.selectByCode("SM828896784997675008");
		System.out.println(JSON.toJSON(result));
	}

	public void getAll() {
		SmMenuDto dto = new SmMenuDto();
		dto.setStart(0);
		dto.setPageSize(10);
		DataResult result = service.findDataAll(dto);
		System.out.println(JSON.toJSON(result));
		PageResult result2 = service.findEntityToPage(dto);
		System.out.println(JSON.toJSON(result2));
	}

	public void del() {
		RootResult result = service.deleteByCode("SM828896784997675008");
		System.out.println(JSON.toJSON(result));
	}
}
