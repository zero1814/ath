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
		entity.setGroupCode("SMG1000");
		entity.setName("菜单相关");
		entity.setCreateUser("system");
		service.insertSelective(entity);
		SmMenu entity1 = new SmMenu();
		entity1.setCode(CodeHelper.getUniqueCode("SM"));
		entity1.setGroupCode("SMG1000");
		entity1.setParentCode(entity.getCode());
		entity1.setName("菜单管理");
		entity1.setPageCode("SP870104770323410944");
		entity1.setCreateUser("system");
		service.insertSelective(entity1);
	}

	public void edit() {
		SmMenu entity = new SmMenu();
		entity.setCode("SM869797002345443328");
		entity.setGroupCode("SMG1000");
		entity.setName("测试-改");
		entity.setPageCode("00000");
		entity.setUpdateUser("update");
		service.updateByCode(entity);

	}

	public void sel() {
		EntityResult result = service.selectByCode("SM869797002345443328");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("SM869797002345443328");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void findAll() {
	}
}
