package org.module.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.CodeHelper;
import org.module.mapper.system.SmDefineMapper;
import org.module.model.system.SmDefine;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class SmDefineTest {

	@Autowired
	private SmDefineMapper mapper;

	@Test
	public void insert() {
		SmDefine entity = new SmDefine();
		entity.setCode(CodeHelper.getCode("SD"));
		entity.setName("test");
		entity.setCreateUser("test");
		entity.setCreateTime(DateUtil.getSysDateTime());
		mapper.insertSelective(entity);
	}
}
