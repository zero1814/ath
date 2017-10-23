package system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.helper.CodeHelper;
import org.module.model.system.user.SmRole;
import org.module.service.system.user.ISmRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmRoleTest {

	@Autowired
	private ISmRoleService service;

	@Test
	public void insert() {
		SmRole entity = new SmRole();
		entity.setCode(CodeHelper.getUniqueCode("SR"));
		entity.setName("测试");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void edit() {
		SmRole entity = new SmRole();
		entity.setCode("SR869802533609009152");
		entity.setName("测试-改");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SR869802533609009152");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		BaseResult result = service.deleteByCode("SR869802533609009152");
		System.out.println(JSON.toJSON(result));
	}
}
