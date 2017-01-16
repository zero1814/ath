package org.system.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmMenuGroupTest {

	@Autowired
	private ISmMenuGroupService service;

	public void insert() {
		SmMenuGroup system = new SmMenuGroup();
		system.setCode(CodeHelper.getUniqueCode("SM"));
		system.setName("系统相关");
		system.setCreateUser("admin");
		service.insertSelective(system);

		SmMenuGroup product = new SmMenuGroup();
		product.setCode(CodeHelper.getUniqueCode("SM"));
		product.setName("商品相关");
		product.setCreateUser("admin");
		service.insertSelective(product);

		SmMenuGroup seller = new SmMenuGroup();
		seller.setCode(CodeHelper.getUniqueCode("SM"));
		seller.setName("商户相关");
		seller.setCreateUser("admin");
		service.insertSelective(seller);

		SmMenuGroup order = new SmMenuGroup();
		order.setCode(CodeHelper.getUniqueCode("SM"));
		order.setName("订单相关");
		order.setCreateUser("admin");
		service.insertSelective(order);

		SmMenuGroup activity = new SmMenuGroup();
		activity.setCode(CodeHelper.getUniqueCode("SM"));
		activity.setName("活动相关");
		activity.setCreateUser("admin");
		service.insertSelective(activity);
	}

	public void delete() {
		service.deleteByCode("SM816070848015233024");
	}

	@Test
	public void getMenu() {
		DataResult result = service.getMenuData(null);
		System.out.println(JSONArray.toJSON(result));
	}
}
