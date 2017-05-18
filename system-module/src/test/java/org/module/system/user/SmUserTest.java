package org.module.system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.util.MD5Util;
import org.module.helper.CodeHelper;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmUserTest {

	@Autowired
	private ISmUserService service;

	public void insert() {
		SmUser entity = new SmUser();
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		entity.setUserName("admin");
		entity.setPassword(MD5Util.md5Hex("password"));
		entity.setRealName("张三");
		entity.setStatus("0");
		entity.setTypeCode("teee");
		entity.setCreateUser("system");
		service.insertSelective(entity);
	}

	public void update() {
		SmUser entity = new SmUser();
		entity.setCode("SU864996946777993216");
		entity.setUserName("admin0002");
		entity.setPassword(MD5Util.md5Hex("322131321"));
		entity.setRealName("李四");
		entity.setStatus("1");
		entity.setTypeCode("231321");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SU864996946777993216");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SU864996946777993216");
		System.out.println(JSON.toJSON(result));
	}
}
