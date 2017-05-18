package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.user.UmDefine;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.user.IUmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class UmDefineTest {

	@Autowired
	private IUmDefineService service;

	public void insert() {
		UmDefine entity = new UmDefine();
		entity.setCode(CodeHelper.getUniqueCode("UD"));
		entity.setName("商户相关");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void update() {
		UmDefine entity = new UmDefine();
		entity.setCode("UD864274322254983168");
		entity.setParentCode("10000");
		entity.setName("商户相关001");
		entity.setUpdateUser("test1");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("UD864274322254983168");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("UD864274322254983168");
		System.out.println(JSON.toJSON(result));
	}
}
