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

	public void insert() {
		SmPage entity = new SmPage();
		entity.setCode(CodeHelper.getUniqueCode("SP"));
		entity.setName("按钮样式管理");
		entity.setUrl("sys/test/index.htm");
		entity.setCreateUser("admin");
		entity.setDescription("测试");
		service.insertSelective(entity);
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

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SP831771172612861952");
		System.out.println(JSON.toJSON(result));
	}
}
