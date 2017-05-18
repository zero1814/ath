package org.module.system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuGroupTest {

	@Autowired
	private ISmMenuGroupService service;

	public void insert() {
		SmMenuGroup entity = new SmMenuGroup();
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setName("系统相关");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}

	public void edit() {
		SmMenuGroup entity = new SmMenuGroup();
		entity.setCode("SM828874795155189760");
		entity.setName("系统相关-改");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult result = service.selectByCode("SM828874795155189760");
		System.out.println(JSON.toJSON(result));
	}

	public void getAll() {
		SmMenuGroupDto dto = new SmMenuGroupDto();
		// dto.setStart(0);
		// dto.setPageSize(10);
		// PageResult result = service.findEntityToPage(dto);
		// System.out.println(JSON.toJSON(result));
		DataResult result = service.findDataAll(dto);
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("SM828874795155189760");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void findMenuByGroup() {
		DataResult result = service.findDataAll();
		System.out.println(JSON.toJSON(result));
	}
}
