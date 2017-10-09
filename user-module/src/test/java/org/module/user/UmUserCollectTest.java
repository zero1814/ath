package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.user.UmUserCollect;
import org.module.result.EntityResult;
import org.module.result.BaseResult;
import org.module.service.user.IUmUserCollectService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml",
		"classpath:spring/spring-redis.xml" })
public class UmUserCollectTest {

	@Autowired
	private IUmUserCollectService service;

	public void insert() {
		UmUserCollect entity = new UmUserCollect();
		entity.setCode(CodeHelper.getUniqueCode("UUC"));
		entity.setUserCode("111");
		entity.setCollectCode("111");
		entity.setCollectType("111");
		entity.setCreateUser("insert");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);
	}

	public void sel() {
		EntityResult result = service.selectByCode("UUC888299804378001408");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		BaseResult result = service.deleteByCode("UUC888299804378001408");
		System.out.println(JSON.toJSON(result));
	}
}
