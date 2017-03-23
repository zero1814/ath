package org.module.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.db.DmColumnType;
import org.module.service.db.IDmColumnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class DmColumnTypeTest {

	@Autowired
	private IDmColumnTypeService service;

	public void insert() {
		DmColumnType entity = new DmColumnType();
		entity.setCode(CodeHelper.getUniqueCode("DCT"));
		entity.setEnName("VARCHAR(50)");
		entity.setName("字符串");
		entity.setComment("字符串类型，数据库类型为VARCHAR长度定位为50");
		entity.setCreateUser("admin");
		service.insertSelective(entity);

		DmColumnType entity1 = new DmColumnType();
		entity1.setCode(CodeHelper.getUniqueCode("DCT"));
		entity1.setEnName("VARCHAR(200)");
		entity1.setName("中长字符串");
		entity1.setComment("字符串类型，数据库类型为VARCHAR长度定义为200");
		entity1.setCreateUser("admin");
		service.insertSelective(entity1);

		DmColumnType entity2 = new DmColumnType();
		entity2.setCode(CodeHelper.getUniqueCode("DCT"));
		entity2.setEnName("VARCHAR(500)");
		entity2.setName("长字符串");
		entity2.setComment("字符串类型，数据库类型为VARCHAR长度定义为500");
		entity2.setCreateUser("admin");
		service.insertSelective(entity2);

		DmColumnType entity3 = new DmColumnType();
		entity3.setCode(CodeHelper.getUniqueCode("DCT"));
		entity3.setEnName("TEXT");
		entity3.setName("超长字符串");
		entity3.setComment("字符串类型，数据库类型为TEXT");
		entity3.setCreateUser("admin");
		service.insertSelective(entity3);

		DmColumnType entity4 = new DmColumnType();
		entity4.setCode(CodeHelper.getUniqueCode("DCT"));
		entity4.setEnName("INT");
		entity4.setName("整数类型");
		entity4.setComment("整数类型，数据库类型为INT");
		entity4.setCreateUser("admin");
		service.insertSelective(entity4);

		DmColumnType entity5 = new DmColumnType();
		entity5.setCode(CodeHelper.getUniqueCode("DCT"));
		entity5.setEnName("DECIMAL(10,2)");
		entity5.setName("小数类型");
		entity5.setComment("小数类型，数据库类型为DECIMAL");
		entity5.setCreateUser("admin");
		service.insertSelective(entity5);
	}

	@Test
	public void edit() {
		DmColumnType entity1 = new DmColumnType();
		entity1.setCode("DCT844799097813594112");
		entity1.setEnName("VARCHAR(200)");
		entity1.setName("中长字符串");
		entity1.setComment("字符串类型，数据库类型为VARCHAR长度定义为200");
		entity1.setUpdateUser("admin");
		service.updateByCode(entity1);
	}
}
