package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.db.DmColumn;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.db.IDmColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class ColumnTest {

	@Autowired
	private IDmColumnService service;

	
	public void insert() {
		DmColumn entity = new DmColumn();
		entity.setCode(CodeHelper.getUniqueCode("DC"));
		entity.setName("名称");
		entity.setEnName("name");
		entity.setTableCode("table");
		entity.setIsDefault(1);
		entity.setCreateUser("add");
		entity.setTypeCode("Type");
		entity.setComment("名称");
		service.insertSelective(entity);
	}

	public void edit() {
		DmColumn entity = new DmColumn();
		entity.setCode("DC857481625728970752");
		entity.setName("名称-测试");
		entity.setEnName("name-test");
		entity.setTableCode("table-01");
		entity.setIsDefault(1);
		entity.setUpdateUser("edit");
		entity.setTypeCode("Type000");
		entity.setComment("名称-测试");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("DC857481625728970752");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("DC857481625728970752");
		System.out.println(JSON.toJSON(result));
	}
}
