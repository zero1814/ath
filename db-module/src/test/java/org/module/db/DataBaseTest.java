package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.util.DateUtil;
import org.module.model.db.DmDatabase;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.db.IDmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class DataBaseTest {

	@Autowired
	private IDmDatabaseService service;

	@Test
	public void insert() {
		DmDatabase entity = new DmDatabase();
		entity.setCode(CodeHelper.getUniqueCode("DD"));
		entity.setEnName("systemmodule");
		entity.setName("系统模块");
		entity.setComment("系统相关");
		entity.setCreateUser("add");
		entity.setUrl(
				"jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	public void edit() {
		DmDatabase entity = new DmDatabase();
		entity.setCode("DD857469847359975424");
		entity.setEnName("systemmodule");
		entity.setName("系统模块测试");
		entity.setComment("系统相关测试");
		entity.setUpdateUser("edit");
		entity.setUrl(
				"jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		entity.setUpdateTime(DateUtil.getSysDateTime());
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("DD857469847359975424");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("DD857469847359975424");
		System.out.println(JSON.toJSON(result));
	}
}
