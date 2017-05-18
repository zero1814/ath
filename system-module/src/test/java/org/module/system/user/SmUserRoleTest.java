package org.module.system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.system.user.SmUserRole;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.user.ISmUesrRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmUserRoleTest {

	@Autowired
	private ISmUesrRoleService service;

	@Test
	public void insert() {
		SmUserRole entity = new SmUserRole();
		entity.setUserCode("123");
		entity.setRoleCode("1231");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void sel() {
		EntityResult result = service.selectByUserCode("123");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByUserCode("123");
		System.out.println(JSON.toJSON(result));
	}
}
