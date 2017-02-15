package org.module.system.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.page.SmPage;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageTest {

	@Autowired
	private ISmPageService service;

	@Test
	public void insert() {
		SmPage entity = new SmPage();
		entity.setCode(CodeHelper.getUniqueCode("SP"));
		entity.setName("菜单组管理");
		entity.setUrl("system/menugroup/index.htm");
		entity.setCreateUser("admin");
		entity.setDescription("用于管理菜单组信息");
		service.insertSelective(entity);
		SmPage entity1 = new SmPage();
		entity1.setCode(CodeHelper.getUniqueCode("SP"));
		entity1.setName("菜单管理");
		entity1.setUrl("system/menu/index.htm");
		entity1.setCreateUser("admin");
		entity1.setDescription("用于管理菜单信息");
		service.insertSelective(entity1);
	}

	public void edit() {
		SmPage entity = new SmPage();
		entity.setCode("SP831771172612861952");
		entity.setName("按钮样式");
		entity.setUrl("index.htm");
		entity.setUpdateUser("admin");
		entity.setDescription("测试修改");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult<SmPage> result = service.selectByCode("SP831771172612861952");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("SP831771172612861952");
		System.out.println(JSON.toJSON(result));
	}
}
