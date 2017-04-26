package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.util.DateUtil;
import org.module.model.db.DmDatabase;
import org.module.service.db.IDmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		entity.setCreateUser("test");
		entity.setUrl("jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}
}
