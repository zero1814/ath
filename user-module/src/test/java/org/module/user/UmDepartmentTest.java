package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.CodeHelper;
import org.module.model.user.UmDepartment;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.user.IUmDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class UmDepartmentTest {

	@Autowired
	private IUmDepartmentService service;

	public void insert() {
		UmDepartment entity = new UmDepartment();
		entity.setCode(CodeHelper.getUniqueCode("UD"));
		entity.setCompanyCode("111");
		entity.setName("测试");
		entity.setPrincipal("测试");
		entity.setCreateUser("add");
		service.insertSelective(entity);
	}

	public void update() {
		UmDepartment entity = new UmDepartment();
		entity.setCode("UD864639053432090624");
		entity.setCompanyCode("2222");
		entity.setName("测试-update");
		entity.setPrincipal("测试-update");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("UD864639053432090624");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("UD864639053432090624");
		System.out.println(JSON.toJSON(result));
	}
}
