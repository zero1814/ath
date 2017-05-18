package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.CodeHelper;
import org.module.model.db.DmTableIndex;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.db.IDmTableIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class TableIndexTest {

	@Autowired
	private IDmTableIndexService service;

	public void insert() {
		DmTableIndex entity = new DmTableIndex();
		entity.setCode(CodeHelper.getUniqueCode("DTI"));
		entity.setName("唯一约束");
		entity.setEnName("unique_code");
		entity.setContent("column1.column2");
		entity.setContent("唯一键约束");
		entity.setCreateUser("add");
		entity.setTableCode("table");
		service.insertSelective(entity);
	}

	@Test
	public void update() {
		DmTableIndex entity = new DmTableIndex();
		entity.setCode("DTI857768126698221568");
		entity.setName("唯一约束");
		entity.setEnName("unique_code");
		entity.setContent("column1.column2");
		entity.setContent("唯一键约束");
		entity.setUpdateUser("edit");
		entity.setTableCode("table");
		service.updateByCode(entity);

	}

	public void sel() {
		EntityResult result = service.selectByCode("DTI857768126698221568");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("DTI857768126698221568");
		System.out.println(JSON.toJSON(result));
	}
}
