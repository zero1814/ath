package org.system.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuGroupTest {

	@Autowired
	private ISmMenuGroupService service;
	@Autowired
	private SmMenuGroupMapper mapper;

	@Test
	public void insert() {
		SmMenuGroup entity = new SmMenuGroup();
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setName("系统相关");
		System.out.println(mapper.insertSelective(entity));
	}
}
