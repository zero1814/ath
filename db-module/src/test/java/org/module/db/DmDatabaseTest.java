package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.db.DmDatabase;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.db.IDmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class DmDatabaseTest {

	@Autowired
	private IDmDatabaseService service;

	public void insert() {
		DmDatabase entity = new DmDatabase();
		entity.setCode(CodeHelper.getUniqueCode("DB"));
		entity.setName("商品库");
		entity.setEnName("productmodule");
		entity.setComment("商品相关表数据库");
		entity.setUrl("127.0.0.1:3309");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}

	public void update() {
		DmDatabase entity = new DmDatabase();
		entity.setCode("DB841960986742091776");
		entity.setName("商品库(改)");
		entity.setEnName("productmodule_edit");
		entity.setComment("商品相关表数据库");
		entity.setUrl("127.0.0.1:3309");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("DB841960986742091776");
		System.out.println(JSONObject.toJSON(result));
	}
	
	@Test
	public void del(){
		RootResult result = service.deleteByCode("DB841960986742091776");
		System.out.println(JSONObject.toJSON(result));
	}
}
