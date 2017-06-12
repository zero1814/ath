package page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPageTable;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageTableTest {

	@Autowired
	private ISmPageTableService service;

	public void insert() {
		SmPageTable entity = new SmPageTable();
		entity.setCode(CodeHelper.getUniqueCode("SPT"));
		entity.setName("测试");
		entity.setPageCode("TEST");
		entity.setCreateUser("add");
		service.insertSelective(entity);
	}

	public void update() {
		SmPageTable entity = new SmPageTable();
		entity.setCode("SPT874194684736434176");
		entity.setName("测试001");
		entity.setPageCode("UPDATE");
		entity.setUpdateUser("edit");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SPT874194684736434176");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SPT874194684736434176");
		System.out.println(JSON.toJSON(result));
	}
}
