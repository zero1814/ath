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

	@Test
	public void insert() {
		SmDefine entity = new SmDefine();
		entity.setCode(CodeHelper.getUniqueCode("SD"));
		entity.setName("页面设置");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
		SmDefine entity1 = new SmDefine();
		entity1.setCode(CodeHelper.getUniqueCode("SD"));
		entity1.setParentCode(entity.getCode());
		entity1.setName("按钮相关设置");
		entity1.setCreateUser("admin");
		service.insertSelective(entity1);
		SmDefine entity2 = new SmDefine();
		entity2.setCode(CodeHelper.getUniqueCode("SD"));
		entity2.setParentCode(entity1.getCode());
		entity2.setName("区域设置");
		entity2.setCreateUser("admin");
		service.insertSelective(entity2);
		SmDefine entity3 = new SmDefine();
		entity3.setCode(CodeHelper.getUniqueCode("SD"));
		entity3.setParentCode(entity2.getCode());
		entity3.setName("操作区域");
		entity3.setCreateUser("admin");
		service.insertSelective(entity3);
		SmDefine entity4 = new SmDefine();
		entity4.setCode(CodeHelper.getUniqueCode("SD"));
		entity4.setParentCode(entity2.getCode());
		entity4.setName("数据区域");
		entity4.setCreateUser("admin");
		service.insertSelective(entity4);
		SmDefine entity5 = new SmDefine();
		entity5.setCode(CodeHelper.getUniqueCode("SD"));
		entity5.setParentCode(entity1.getCode());
		entity5.setName("操作类型");
		entity5.setCreateUser("admin");
		service.insertSelective(entity5);
		SmDefine entity6 = new SmDefine();
		entity6.setCode(CodeHelper.getUniqueCode("SD"));
		entity6.setParentCode(entity5.getCode());
		entity6.setName("本页跳转");
		entity6.setCreateUser("admin");
		service.insertSelective(entity6);
		SmDefine entity7 = new SmDefine();
		entity7.setCode(CodeHelper.getUniqueCode("SD"));
		entity7.setParentCode(entity5.getCode());
		entity7.setName("新页面打开");
		entity7.setCreateUser("admin");
		service.insertSelective(entity7);
		SmDefine entity8 = new SmDefine();
		entity8.setCode(CodeHelper.getUniqueCode("SD"));
		entity8.setParentCode(entity5.getCode());
		entity8.setName("脚本");
		entity8.setCreateUser("admin");
		service.insertSelective(entity8);
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
		EntityResult<SmDefine> result = service.selectByCode("SD828939197468372992");
		System.out.println(JSON.toJSON(result));
	}
}
