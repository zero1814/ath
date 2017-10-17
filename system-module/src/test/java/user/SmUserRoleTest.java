package user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.result.BaseResult;
import org.module.base.result.DataResult;
import org.module.model.system.user.SmUserRole;
import org.module.service.system.user.ISmUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmUserRoleTest {

	@Autowired
	private ISmUserRoleService service;

	public void insert() {
		SmUserRole entity = new SmUserRole();
		entity.setUserCode("1");
		entity.setRoleCode("2");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void sel() {
		DataResult result = service.selectByUserCode("1");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		BaseResult result = service.deleteByUserCode("1");
		System.out.println(JSON.toJSON(result));
	}
}
