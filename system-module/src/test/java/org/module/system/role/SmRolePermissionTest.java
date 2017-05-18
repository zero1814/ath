package org.module.system.role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.role.SmRolePermission;
import org.module.service.system.role.ISmRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmRolePermissionTest {

	@Autowired
	private ISmRolePermissionService service;

	public void insert() {
		SmRolePermission entity = new SmRolePermission();
		entity.setCode(CodeHelper.getUniqueCode("RP"));
		entity.setRoleCode("1");
		entity.setMenuPermissionCode("1");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}
	
	@Test
	public void getMenus(){
		JSONArray array = service.getMenus();
		System.out.println(array);
	}
}
