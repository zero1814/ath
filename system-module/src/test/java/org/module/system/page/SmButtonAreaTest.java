package org.module.system.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.page.SmButtonArea;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmButtonAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmButtonAreaTest {

	@Autowired
	private ISmButtonAreaService service;

	@Test
	public void insert() {
		SmButtonArea entity = new SmButtonArea();
		entity.setCode(CodeHelper.getUniqueCode("PB"));
		entity.setName("数据区域");
		entity.setCreateUser("admin");
		service.insertSelective(entity);
		SmButtonArea entity1 = new SmButtonArea();
		entity1.setCode(CodeHelper.getUniqueCode("PB"));
		entity1.setName("操作区域");
		entity1.setCreateUser("admin");
		service.insertSelective(entity1);
	}

	public void edit() {
		SmButtonArea entity = new SmButtonArea();
		entity.setCode("PB831762245313622016");
		entity.setName("数据区域01");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult<SmButtonArea> result = service.selectByCode("PB831762245313622016");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("PB831762245313622016");
		System.out.println(JSON.toJSON(result));
	}
}
