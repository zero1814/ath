package org.module.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.SmDefine;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.ISmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmDefineTest {

	@Autowired
	private ISmDefineService service;

	public void insert() {
		SmDefine entity = new SmDefine();
		entity.setCode(CodeHelper.getUniqueCode("SD"));
		entity.setName("测试");
		entity.setCreateUser("admin");
		RootResult result = service.insertSelective(entity);
		System.out.println(JSON.toJSON(result));
	}

	public void edit() {
		SmDefine entity = new SmDefine();
		entity.setCode("SD828939197468372992");
		entity.setName("测试001");
		entity.setUpdateUser("admin");
		RootResult result = service.updateByCode(entity);
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void selByCode() {
		EntityResult<SmDefine> result = service.selectByCode("SD828939197468372992");
		System.out.println(JSON.toJSON(result));
	}
}
