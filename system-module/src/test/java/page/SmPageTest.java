package page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPage;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageService;
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
		entity.setGroupCode("SPG870101120909832192");
		entity.setName("菜单组管理");
		entity.setUrl("system/menu/group/index.htm");
		entity.setCreateUser("system");
		service.insertSelective(entity);

		SmPage entity1 = new SmPage();
		entity1.setCode(CodeHelper.getUniqueCode("SP"));
		entity1.setGroupCode("SPG870101120909832192");
		entity1.setName("菜单管理");
		entity1.setUrl("system/menu/index.htm");
		entity1.setCreateUser("system");
		service.insertSelective(entity1);

		SmPage entity2 = new SmPage();
		entity2.setCode(CodeHelper.getUniqueCode("SP"));
		entity2.setGroupCode("SPG870101120909832192");
		entity2.setName("页面组管理");
		entity2.setUrl("system/page/group/index.htm");
		entity2.setCreateUser("system");
		service.insertSelective(entity2);

		SmPage entity3 = new SmPage();
		entity3.setCode(CodeHelper.getUniqueCode("SP"));
		entity3.setGroupCode("SPG870101120909832192");
		entity3.setName("页面管理");
		entity3.setUrl("system/page/group/index.htm");
		entity3.setCreateUser("system");
		service.insertSelective(entity3);
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

	public void del() {
		RootResult result = service.deleteByCode("SP869797891529502720");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void all() {
	}
}
