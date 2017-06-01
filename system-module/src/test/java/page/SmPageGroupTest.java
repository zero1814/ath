package page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPageGroup;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageGroupTest {

	@Autowired
	private ISmPageGroupService service;

	public void insert() {
		SmPageGroup entity = new SmPageGroup();
		entity.setCode(CodeHelper.getUniqueCode("SPG"));
		entity.setName("系统相关");
		entity.setCreateUser("insert");
		service.insertSelective(entity);

		SmPageGroup entity1 = new SmPageGroup();
		entity1.setCode(CodeHelper.getUniqueCode("SPG"));
		entity1.setParentCode(entity.getCode());
		entity1.setName("菜单管理");
		entity1.setCreateUser("insert");
		service.insertSelective(entity1);

		SmPageGroup entity2 = new SmPageGroup();
		entity2.setCode(CodeHelper.getUniqueCode("SPG"));
		entity2.setParentCode(entity.getCode());
		entity2.setName("系统管理");
		entity2.setCreateUser("insert");
		service.insertSelective(entity2);
	}

	public void update() {
		SmPageGroup entity = new SmPageGroup();
		entity.setCode("SPG870088104608788480");
		entity.setParentCode("11233");
		entity.setName("系统相关");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SPG870088104608788480");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		RootResult result = service.deleteByCode("SPG870088104608788480");
		System.out.println(JSON.toJSON(result));
	}
	
	@Test
	public void findAll(){
		DataResult result = service.findDataAll();
		System.out.println(JSON.toJSON(result));
	}
}
