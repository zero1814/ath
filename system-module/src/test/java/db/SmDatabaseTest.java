package db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.BaseTest;
import org.module.dto.system.db.SmDatabaseDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.db.SmDatabase;
import org.module.service.system.db.ISmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmDatabaseTest extends BaseTest {

	@Autowired
	private ISmDatabaseService service;

	public void insert() {
		SmDatabase entity = new SmDatabase();
		entity.setCode(CodeHelper.getUniqueCode("SD"));
		entity.setName("test");
		entity.setDriver("132");
		entity.setUrl("123212");
		entity.setUserName("test");
		entity.setPassword("123");
		entity.setCreateUser("insert");
		service.insertSelective(entity);
	}

	public void edit() {
		SmDatabase entity = new SmDatabase();
		entity.setCode("SD884707473900957696");
		entity.setName("test000");
		entity.setDriver("1320000");
		entity.setUrl("123212000");
		entity.setUserName("test000");
		entity.setPassword("123000");
		entity.setUpdateUser("edit");
		service.updateByCode(entity);
	}

	public void sel() {
		System.out.println(JSON.toJSON(service.selectByCode("SD884707473900957696")));
	}

	@Test
	public void page(){
		System.out.println(JSON.toJSON(service.findEntityToPage(new SmDatabaseDto())));
	}
}
