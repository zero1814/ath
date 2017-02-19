package org.module.system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.model.system.menu.SmMenuPermission;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuPermissionTest {

	@Autowired
	private ISmMenuPermissionService service;

	public void insert() {
		SmMenuPermission entity = new SmMenuPermission();
		entity.setCode(CodeHelper.getUniqueCode("SMP"));
		entity.setMenuCode("SM828916170882019328");
		entity.setName("添加");
		entity.setDescription("菜单添加权限");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}

	public void edit() {
		SmMenuPermission entity = new SmMenuPermission();
		entity.setCode("SMP828916750748741632");
		entity.setName("添加-改");
		entity.setDescription("测试");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult result = service.selectByCode("SMP828916750748741632");
		System.out.println(JSON.toJSON(result));
	}

	public void getAll() {
		SmMenuPermissionDto dto = new SmMenuPermissionDto();
		DataResult result = service.findDataAll(dto);
		System.out.println(JSON.toJSON(result));
		dto.setStart(0);
		dto.setPageSize(10);
		PageResult result2 = service.findEntityToPage(dto);
		System.out.println(JSON.toJSON(result2));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SMP828916750748741632");
		System.out.println(JSON.toJSON(result));
	}
}
