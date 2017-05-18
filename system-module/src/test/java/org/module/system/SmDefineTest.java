package org.module.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
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

	@Test
	public void insert() {
		SmDefine entity = new SmDefine();
		entity.setCode(CodeHelper.getUniqueCode("SD"));
		entity.setName("权限类型");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
//		SmDefine entity0 = new SmDefine();
//		entity0.setCode(CodeHelper.getUniqueCode("SD"));
//		entity0.setParentCode(entity.getCode());
//		entity0.setName("访问");
//		entity0.setCreateUser("admin");
//		service.insertSelective(entity0);
//		SmDefine entity1 = new SmDefine();
//		entity1.setCode(CodeHelper.getUniqueCode("SD"));
//		entity1.setParentCode(entity.getCode());
//		entity1.setName("添加");
//		entity1.setCreateUser("admin");
//		service.insertSelective(entity1);
//		SmDefine entity2 = new SmDefine();
//		entity2.setCode(CodeHelper.getUniqueCode("SD"));
//		entity2.setParentCode(entity.getCode());
//		entity2.setName("编辑");
//		entity2.setCreateUser("admin");
//		service.insertSelective(entity2);
//		SmDefine entity3 = new SmDefine();
//		entity3.setCode(CodeHelper.getUniqueCode("SD"));
//		entity3.setParentCode(entity.getCode());
//		entity3.setName("删除");
//		entity3.setCreateUser("admin");
//		service.insertSelective(entity3);
//		SmDefine entity4 = new SmDefine();
//		entity4.setCode(CodeHelper.getUniqueCode("SD"));
//		entity4.setParentCode(entity.getCode());
//		entity4.setName("查询");
//		entity4.setCreateUser("admin");
//		service.insertSelective(entity4);
	}

	public void edit() {
		SmDefine entity = new SmDefine();
		entity.setCode("SD828939197468372992");
		entity.setName("测试001");
		entity.setUpdateUser("admin");
		RootResult result = service.updateByCode(entity);
		System.out.println(JSON.toJSON(result));
	}

	public void selByCode() {
		EntityResult result = service.selectByCode("SD828939197468372992");
		System.out.println(JSON.toJSON(result));
	}
}
