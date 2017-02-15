package org.module.system.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.page.SmPageAuthority;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageAuthorityTest {

	@Autowired
	private ISmPageAuthorityService service;

	@Test
	public void insert() {
		SmPageAuthority entity = new SmPageAuthority();
		entity.setCode(CodeHelper.getUniqueCode("PA"));
		entity.setAuthority("{add:0}");
		entity.setCreateUser("admin");
		entity.setPageCode("SP001");
		service.insertSelective(entity);
	}
	
	public void edit(){
		SmPageAuthority entity = new SmPageAuthority();
		entity.setCode("PA831778507037077504");
		entity.setAuthority("{edit:0}");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode(){
		EntityResult<SmPageAuthority> result = service.selectByCode("PA831778507037077504");
		System.out.println(JSON.toJSON(result));
	}

	public void del(){
		RootResult result = service.deleteByCode("PA831778507037077504");
		System.out.println(JSON.toJSON(result));
	}
}
