package org.module.system.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.page.SmButtonStyle;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmButtonStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmButtonStyleTest {

	@Autowired
	private ISmButtonStyleService service;

	@Test
	public void insert() {
		SmButtonStyle entity = new SmButtonStyle();
		entity.setCode(CodeHelper.getUniqueCode("BS"));
		entity.setName("默认");
		entity.setStyle("btn btn-default");
		entity.setCreateUser("admin");
		service.insertSelective(entity);

		SmButtonStyle entity1 = new SmButtonStyle();
		entity1.setCode(CodeHelper.getUniqueCode("BS"));
		entity1.setName("主要");
		entity1.setStyle("btn btn-primary");
		entity1.setCreateUser("admin");
		service.insertSelective(entity1);

		SmButtonStyle entity2 = new SmButtonStyle();
		entity2.setCode(CodeHelper.getUniqueCode("BS"));
		entity2.setName("成功");
		entity2.setStyle("btn btn-success");
		entity2.setCreateUser("admin");
		service.insertSelective(entity2);

		SmButtonStyle entity3 = new SmButtonStyle();
		entity3.setCode(CodeHelper.getUniqueCode("BS"));
		entity3.setName("信息");
		entity3.setStyle("btn btn-info");
		entity3.setCreateUser("admin");
		service.insertSelective(entity3);

		SmButtonStyle entity4 = new SmButtonStyle();
		entity4.setCode(CodeHelper.getUniqueCode("BS"));
		entity4.setName("警告");
		entity4.setStyle("btn btn-warning");
		entity4.setCreateUser("admin");
		service.insertSelective(entity4);

		SmButtonStyle entity5 = new SmButtonStyle();
		entity5.setCode(CodeHelper.getUniqueCode("BS"));
		entity5.setName("危险");
		entity5.setStyle("btn btn-danger");
		entity5.setCreateUser("admin");
		service.insertSelective(entity5);
	}

	public void edit() {
		SmButtonStyle entity = new SmButtonStyle();
		entity.setCode("BS831768717959360512");
		entity.setName("默认");
		entity.setStyle("btn btn-default");
		entity.setUpdateUser("admin");
		service.updateByCode(entity);
	}

	public void selByCode() {
		EntityResult<SmButtonStyle> result = service.selectByCode("BS831768717959360512");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("BS831768717959360512");
		System.out.println(JSON.toJSON(result));
	}
}
