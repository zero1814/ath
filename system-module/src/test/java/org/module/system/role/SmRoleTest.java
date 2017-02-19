package org.module.system.role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.dto.system.role.SmRoleDto;
import org.module.model.system.role.SmRole;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.role.ISmRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmRoleTest {

	@Autowired
	private ISmRoleService service;

	public void insert() {
		SmRole entity = new SmRole();
		entity.setCode(CodeHelper.getUniqueCode("SR"));
		entity.setName("管理员");
		entity.setIntro("后台管理员");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}

	public void edit() {
		SmRole entity = new SmRole();
		entity.setCode("SR828936528817287168");
		entity.setName("超级管理员");
		entity.setUpdateUser("admin");
		RootResult result = service.updateByCode(entity);
		System.out.println(JSON.toJSON(result));
	}

	public void selByCode() {
		EntityResult result = service.selectByCode("SR828936528817287168");
		System.out.println(JSON.toJSON(result));
	}

	public void getAll() {
		SmRoleDto dto = new SmRoleDto();
		DataResult result = service.findDataAll(dto);
		System.out.println(JSON.toJSON(result));
		dto.setStart(0);
		dto.setPageSize(10);
		PageResult result1 = service.findEntityToPage(dto);
		System.out.println(JSON.toJSON(result1));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SR828936528817287168");
		System.out.println(JSON.toJSON(result));
	}
}
