package menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.EntityResult;
import org.module.result.BaseResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuGroupTest {

	@Autowired
	private ISmMenuGroupService service;

	@Test
	public void insert() {
		SmMenuGroup entity = new SmMenuGroup();
		entity.setCode(CodeHelper.getUniqueCode("SMG"));
		entity.setName("后台管理");
		entity.setCreateUser("system");
		service.insertSelective(entity);
	}

	public void edit() {
		SmMenuGroup entity = new SmMenuGroup();
		entity.setCode("SMG869792468005023744");
		entity.setName("测试");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SMG869792468005023744");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		BaseResult result = service.deleteByCode("SMG869792468005023744");
		System.out.println(JSON.toJSON(result));
	}
}
