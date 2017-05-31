package menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuTest {

	@Autowired
	private ISmMenuService service;

	public void insert() {
		SmMenu entity = new SmMenu();
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setGroupCode("1");
		entity.setName("测试");
		entity.setPageCode("34");
		entity.setCreateUser("test");
		service.insertSelective(entity);
	}

	public void edit() {
		SmMenu entity = new SmMenu();
		entity.setCode("SM869797002345443328");
		entity.setGroupCode("123");
		entity.setName("测试-改");
		entity.setPageCode("00000");
		entity.setUpdateUser("update");
		service.updateByCode(entity);

	}

	public void sel() {
		EntityResult result = service.selectByCode("SM869797002345443328");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SM869797002345443328");
		System.out.println(JSON.toJSON(result));
	}
}
