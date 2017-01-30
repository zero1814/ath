package org.module.commons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.model.db.CmDatabase;
import org.module.commons.service.ICmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class CmDatabaseTest {

	@Autowired
	private ICmDatabaseService service;

	@Test
	public void insert() {
		CmDatabase entity = new CmDatabase();
		entity.setCode(CodeHelper.getUniqueCode("CM"));
		entity.setName("系统模块");
		entity.setEnName("systemmodule");
		entity.setUrl(
				"jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
	}
}
