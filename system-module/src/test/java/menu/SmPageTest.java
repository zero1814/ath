package menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmPage;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageTest {

	@Autowired
	private ISmPageService service;

	public void insert() {
		SmPage entity = new SmPage();
		entity.setCode(CodeHelper.getUniqueCode("SP"));
		entity.setName("测试");
		entity.setUrl("ce");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void edit() {
		SmPage entity = new SmPage();
		entity.setCode("SP869797891529502720");
		entity.setName("测试-高");
		entity.setUrl("www.baidu.com");
		entity.setFlagAble(1);
		entity.setParam("param");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SP869797891529502720");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SP869797891529502720");
		System.out.println(JSON.toJSON(result));
	}
}
