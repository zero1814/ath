package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.user.UmCompany;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.user.IUmCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class UmCompanyTest {

	@Autowired
	private IUmCompanyService service;

	public void insert() {
		UmCompany entity = new UmCompany();
		entity.setCode(CodeHelper.getUniqueCode("UC"));
		entity.setName("测试数据");
		entity.setPrincipal("test");
		entity.setAddress("测试数据");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}
	
	public void update(){
		UmCompany entity = new UmCompany();
		entity.setCode("UC864275648070283264");
		entity.setName("测试数据-改");
		entity.setPrincipal("test00232");
		entity.setAddress("测试数据-改");
		entity.setUpdateUser("test001");
		service.updateByCode(entity);
	}
	
	public void sel(){
		EntityResult result = service.selectByCode("UC864275648070283264");
		System.out.println(JSON.toJSON(result));
	}
	
	@Test
	public void del(){
		RootResult result = service.deleteByCode("UC864275648070283264");
		System.out.println(JSON.toJSON(result));
	}
}
