package org.module.system.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.page.SmPageButton;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageButtonTest {

	@Autowired
	private ISmPageButtonService service;

	public void insert() {
		SmPageButton entity = new SmPageButton();
		entity.setCode(CodeHelper.getUniqueCode("PB"));
		entity.setPageCode("SP831798539125256192");
		entity.setStyleCode("BS0012312");
		entity.setOperation("添加");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}

	public void edit() {
		SmPageButton entity = new SmPageButton();
		entity.setCode("PB831781402277048320");
		entity.setPageCode("SP113123002");
		entity.setStyleCode("BS00123232312");
		entity.setOperation("编辑");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult<SmPageButton> result = service.selectByCode("PB831781402277048320");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("PB831781402277048320");
		System.out.println(JSON.toJSON(result));
	}
}
