package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.user.UmUserAddress;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.user.IUmUserAddressService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml",
		"classpath:spring/spring-redis.xml" })
public class UmUserAddressTest {

	@Autowired
	private IUmUserAddressService service;

	public void insert() {
		UmUserAddress entity = new UmUserAddress();
		entity.setCode(CodeHelper.getUniqueCode("UUA"));
		entity.setUserCode("111");
		entity.setAddress("111");
		entity.setProvinceCity("111");
		entity.setArea("111");
		entity.setStatus("111");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	public void edit() {
		UmUserAddress entity = new UmUserAddress();
		entity.setCode("UUA888298337994797056");
		entity.setUserCode("222");
		entity.setAddress("222");
		entity.setProvinceCity("222");
		entity.setArea("222");
		entity.setStatus("222");
		entity.setUpdateUser("edit");
		entity.setUpdateTime(DateUtil.getSysDateTime());
		service.updateByCode(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("UUA888298337994797056");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		RootResult result = service.deleteByCode("UUA888298337994797056");
		System.out.println(JSON.toJSON(result));
	}
}
