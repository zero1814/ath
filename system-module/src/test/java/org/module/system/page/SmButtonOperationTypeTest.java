package org.module.system.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.page.SmButtonOperationType;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmButtonOperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmButtonOperationTypeTest {

	@Autowired
	private ISmButtonOperationTypeService service;

	@Test
	public void insert() {
		SmButtonOperationType entity = new SmButtonOperationType();
		entity.setCode(CodeHelper.getUniqueCode("BOT"));
		entity.setName("新窗口打开");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
		SmButtonOperationType entity1 = new SmButtonOperationType();
		entity1.setCode(CodeHelper.getUniqueCode("BOT"));
		entity1.setName("本窗口跳转");
		entity1.setCreateUser("admin");
		service.insertSelective(entity1);
		SmButtonOperationType entity2 = new SmButtonOperationType();
		entity2.setCode(CodeHelper.getUniqueCode("BOT"));
		entity2.setName("js脚本");
		entity2.setCreateUser("admin");
		service.insertSelective(entity2);
	}

	public void edit() {
		SmButtonOperationType entity = new SmButtonOperationType();
		entity.setCode("BOT831763808874655744");
		entity.setName("脚本");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult<SmButtonOperationType> result = service.selectByCode("BOT831763808874655744");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("BOT831763808874655744");
		System.out.println(JSON.toJSON(result));
	}
}
