package system.menu;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.BaseTest;
import org.module.base.result.EntityResult;
import org.module.base.result.TreeResult;
import org.module.helper.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuTest extends BaseTest {

	@Autowired
	private ISmMenuService service;

	public void insert() {
		SmMenu entity = new SmMenu();
		entity.setCode(CodeHelper.getCode("SM"));
		entity.setName("菜单相关");
		entity.setPageCode("11");
		entity.setGroupCode("ddd");
		entity.setCreateUser("system");
		entity.setCreateTime(DateUtil.getSysDateTime());
		EntityResult result = service.insertSelective(entity);
		System.out.println(JSON.toJSON(result));
	}

	public void update() {
		SmMenu entity = new SmMenu();
		entity.setIcon("55");
		entity.setUpdateUser("ts");
		EntityResult result = service.updateByCode(entity);
		System.out.println(JSON.toJSON(result));
	}

	public void tree() {
		TreeResult result = service.tree("SMG1000");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void sel() {
		List<SmMenu> list = service.findAbleAddChildMenu();
		System.out.println("------------>");
		System.out.println(JSON.toJSON(list));
		System.out.println("------------>");
	}
}
