package org.module.kernel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.kernel.db.CmColumnType;
import org.module.service.kernel.db.ICmColumnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class CmColumnTypeTest {

	@Autowired
	private ICmColumnTypeService service;

	@Test
	public void insert() {
		CmColumnType entity = new CmColumnType();
		entity.setCode(CodeHelper.getUniqueCode("CM"));
		entity.setName("长字符串");
		entity.setEnName("VARCHAR");
		entity.setComment("存储字符串");
		JSONObject area = new JSONObject();
		area.put("min", "100");
		area.put("max", "500");
		entity.setValueArea(area.toJSONString());
		entity.setCreateUser("admin");
		service.insertSelective(entity);
		CmColumnType entity1 = new CmColumnType();
		entity1.setCode(CodeHelper.getUniqueCode("CM"));
		entity1.setName("超长字符串");
		entity1.setEnName("text");
		entity1.setComment("存储字符串");
		entity1.setValueArea("");
		entity1.setCreateUser("admin");
		service.insertSelective(entity1);

		CmColumnType entity2 = new CmColumnType();
		entity2.setCode(CodeHelper.getUniqueCode("CM"));
		entity2.setName("整数");
		entity2.setEnName("INT");
		entity2.setComment("存储整数");
		entity2.setValueArea("");
		entity2.setCreateUser("admin");
		service.insertSelective(entity2);
		CmColumnType entity3 = new CmColumnType();
		entity3.setCode(CodeHelper.getUniqueCode("CM"));
		entity3.setName("浮点数");
		entity3.setEnName("FLOAT");
		entity3.setComment("存储浮点数");
		entity3.setValueArea("");
		entity3.setCreateUser("admin");
		service.insertSelective(entity3);

	}
}
