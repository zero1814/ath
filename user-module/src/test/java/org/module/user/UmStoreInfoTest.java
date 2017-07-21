package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.user.UmStoreInfo;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.user.IUmStoreInfoService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml",
		"classpath:spring/spring-redis.xml" })
public class UmStoreInfoTest {

	@Autowired
	private IUmStoreInfoService service;

	public void insert() {
		UmStoreInfo entity = new UmStoreInfo();
		entity.setCode(CodeHelper.getUniqueCode("USI"));
		entity.setName("测试店铺");
		entity.setStorePicUrl("0000");
		entity.setStoreUrl("11111");
		entity.setStatus("1111");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	public void edit() {
		UmStoreInfo entity = new UmStoreInfo();
		entity.setCode("USI888297482935595008");
		entity.setName("测试店铺-00001");
		entity.setStorePicUrl("2222");
		entity.setStoreUrl("3333");
		entity.setStatus("33");
		entity.setUpdateUser("edit");
		entity.setUpdateTime(DateUtil.getSysDateTime());
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("USI888297482935595008");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("USI888297482935595008");
		System.out.println(JSON.toJSON(result));
	}
}
