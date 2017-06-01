package user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.util.MD5Util;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmUserTest {

	@Autowired
	private ISmUserService service;

	public void insert() {
		SmUser entity = new SmUser();
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		entity.setRealName("测试");
		entity.setUserName("test");
		entity.setPassword(MD5Util.md5Hex("123456"));
		entity.setMail("test@mail.com");
		entity.setPhone("13522231552");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void edit() {
		SmUser entity = new SmUser();
		entity.setCode("SU869808549973192704");
		entity.setRealName("测试-改");
		entity.setUserName("test123");
		entity.setPassword(MD5Util.md5Hex("ssssss"));
		entity.setMail("update@mail.com");
		entity.setPhone("13522231552");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SU869808549973192704");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SU869808549973192704");
		System.out.println(JSON.toJSON(result));
	}
}