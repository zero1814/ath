package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.CodeHelper;
import org.module.model.db.DmTable;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.db.IDmTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class TableTest {

	@Autowired
	private IDmTableService service;

	@Test
	public void insert() {
		DmTable entity = new DmTable();
		entity.setCode(CodeHelper.getUniqueCode("DT"));
		entity.setName("数据库维护表");
		entity.setEnName("dm_database");
		entity.setDbCode("DD857472471727599616");
		entity.setComment("数据库维护表");
		entity.setCreateUser("add");
		service.insertSelective(entity);
	}

	public void update() {
		DmTable entity = new DmTable();
		entity.setCode("DT857476010046648320");
		entity.setName("数据库维护表测试");
		entity.setEnName("dm_database_test");
		entity.setDbCode("DD857472471727599616");
		entity.setComment("数据库维护表测试");
		entity.setUpdateUser("edit");
		service.updateByCode(entity);
	}

	public void sel(){
		EntityResult result = service.selectByCode("DT857476010046648320");
		System.out.println(JSON.toJSON(result));
	}

	public void del(){
		RootResult result = service.deleteByCode("DT857476010046648320");
		System.out.println(JSON.toJSON(result));
	}
}
