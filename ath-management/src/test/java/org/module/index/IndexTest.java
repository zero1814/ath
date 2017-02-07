package org.module.index;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.index.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class IndexTest {

	@Autowired
	private IndexService service;

	@Test
	public void getMenus() {
		List<SmMenuGroup> list = service.getMenus();
		System.out.println(JSON.toJSON(list));
	}
}
