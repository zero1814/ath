package org.module.system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenuPermissionType;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuPermissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuPermissionTypeTest {

	@Autowired
	private ISmMenuPermissionTypeService service;

	public void insert() {
		SmMenuPermissionType entity = new SmMenuPermissionType();
		entity.setCode(CodeHelper.getUniqueCode("SMPT"));
		entity.setName("测试");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void update() {
		SmMenuPermissionType entity = new SmMenuPermissionType();
		entity.setCode("SMPT867926589722062848");
		entity.setName("测试0001");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}
	
	@Test
	public void sel(){
		EntityResult result = service.selectByCode("SMPT867926589722062848");
		System.out.println(JSON.toJSON(result));
	}
	
	@Test
	public void del(){
		RootResult result = service.deleteByCode("SMPT867926589722062848");
		System.out.println(JSON.toJSON(result));	
	}
}
