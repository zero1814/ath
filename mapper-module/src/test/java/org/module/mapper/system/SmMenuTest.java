package org.module.mapper.system;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.util.DateUtil;
import org.module.model.system.SmMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mapper.xml" })
public class SmMenuTest {

	@Autowired
	private SmMenuMapper mapper;

	@Test
	public void insert() {
		SmMenu entity = new SmMenu();
		entity.setName("teesss");
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setCreateUser("test");
		entity.setCreateTime(DateUtil.getSysDateTime());
		entity.setPageCode("PAGE");
		entity.setStatus("NULL");
		entity.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
		mapper.insertSelective(entity);
	}

	public void selByCode() {
		SmMenu entity = mapper.selectByCode("");
	}
}