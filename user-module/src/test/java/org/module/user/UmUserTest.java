package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.util.MD5Util;
import org.module.helper.commons.CodeHelper;
import org.module.model.user.UmUser;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.user.IUmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class UmUserTest {

	@Autowired
	private IUmUserService service;

	public void insert() {
		UmUser entity = new UmUser();
		entity.setCode(CodeHelper.getUniqueCode("UU"));
		entity.setRealName("张三");
		entity.setUserName("test");
		entity.setDepartmentCode("123");
		entity.setPassword(MD5Util.md5Hex("123"));
		entity.setStatus("1");
		entity.setCreateUser("add");
		service.insertSelective(entity);
	}

	public void update() {
		UmUser entity = new UmUser();
		entity.setCode("UU864640205645148160");
		entity.setRealName("李四");
		entity.setUserName("test-update");
		entity.setDepartmentCode("123133");
		entity.setPassword(MD5Util.md5Hex("3322"));
		entity.setStatus("2");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	
	public void sel() {
		EntityResult result = service.selectByCode("UU864640205645148160");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("UU864640205645148160");
		System.out.println(JSON.toJSON(result));
	}
}
