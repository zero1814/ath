package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.db.DmColumnType;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.db.IDmColumnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class ColumnTypeTest {

	@Autowired
	private IDmColumnTypeService service;

	public void insert() {
		DmColumnType entity = new DmColumnType();
		entity.setCode(CodeHelper.getUniqueCode("DCT"));
		entity.setName("长字符");
		entity.setValue("varchar(200)");
		entity.setCreateUser("add");
		entity.setComment("存储200个字符");
		service.insertSelective(entity);
	}

	
	public void update() {
		DmColumnType entity = new DmColumnType();
		entity.setCode("DCT857760246804770816");
		entity.setName("中长字符");
		entity.setValue("varchar(100)");
		entity.setUpdateUser("edit");
		entity.setComment("存储100个字符");
		service.updateByCode(entity);
	}
	
	public void sel() {
		EntityResult result = service.selectByCode("DCT857760246804770816");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("DCT857760246804770816");
		System.out.println(JSON.toJSON(result));
	}
}
