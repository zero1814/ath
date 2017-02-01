package org.module.kernel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.kernel.db.CmColumn;
import org.module.service.kernel.db.ICmColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class CmColumnTest {

	@Autowired
	private ICmColumnService service;

	@Test
	public void insert() {
		CmColumn entity = new CmColumn();
		entity.setCode(CodeHelper.getUniqueCode("CM"));
		entity.setCreateUser("admin");
	}
}
