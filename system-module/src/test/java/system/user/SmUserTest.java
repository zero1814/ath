package system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.BaseTest;
import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.helper.CodeHelper;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.module.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml",
		"classpath:spring/spring-redis.xml" })
public class SmUserTest extends BaseTest {

	@Autowired
	private ISmUserService service;

	@Test
	public void insert() {
		SmUser entity = new SmUser();
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		entity.setRealName("测试");
		entity.setUserName("test");
		entity.setPassword(MD5Util.md5Hex("123456"));
		entity.seteMail("11111@11.com");
		entity.setPhone("13522231552");
		entity.setCreateUser("test");
		entity.setStatus("0");
		service.insertSelective(entity);
	}

	public void edit() {
		SmUser entity = new SmUser();
		entity.setCode("SU869808549973192704");
		entity.setRealName("测试-改");
		entity.setUserName("test123");
		entity.setPassword(MD5Util.md5Hex("ssssss"));
		entity.seteMail("update@mail.com");
		entity.setPhone("13522231552");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.login("test", "123456");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		BaseResult result = service.deleteByCode("SU869808549973192704");
		System.out.println(JSON.toJSON(result));
	}
}
