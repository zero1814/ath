package page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPageTableColumn;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmPageTableColumnTest {

	@Autowired
	private ISmPageTableColumnService service;

	public void add() {
		SmPageTableColumn entity = new SmPageTableColumn();
		entity.setCode(CodeHelper.getUniqueCode("SPTC"));
		entity.setTableCode("1111");
		entity.setField("createUser");
		entity.setTitle("测试");
		entity.setFormatter("function(){alert(1);}");
		entity.setCreateUser("insert");
		service.insertSelective(entity);
	}

	public void edit() {
		SmPageTableColumn entity = new SmPageTableColumn();
		entity.setCode("SPTC874196642134224896");
		entity.setTableCode("1111");
		entity.setField("updateUser");
		entity.setTitle("测试0002222");
		entity.setFormatter("function(){alert(10000);}");
		entity.setUpdateUser("update");
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("SPTC874196642134224896");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("SPTC874196642134224896");
		System.out.println(JSON.toJSON(result));
	}
}
