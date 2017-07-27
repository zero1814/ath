package org.module.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.helper.commons.CodeHelper;
import org.module.model.product.PmDefine;
import org.module.result.TreeResult;
import org.module.service.product.IPmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class PmDefineTest {

	@Autowired
	private IPmDefineService service;

	@Test
	public void insert() {
		PmDefine entity = new PmDefine();
		entity.setCode(CodeHelper.getUniqueCode("PD"));
		entity.setName("测试");
		entity.setCreateUser("test");
		service.insertSelective(entity);
		PmDefine entity1 = new PmDefine();
		entity1.setCode(CodeHelper.getUniqueCode("PD"));
		entity1.setParentCode(entity.getCode());
		entity1.setName("测试001");
		entity1.setCreateUser("test");
		service.insertSelective(entity1);
		PmDefine entity2 = new PmDefine();
		entity2.setCode(CodeHelper.getUniqueCode("PD"));
		entity2.setParentCode(entity.getCode());
		entity2.setName("测试002");
		entity2.setCreateUser("test");
		service.insertSelective(entity2);
	}

	@Test
	public void tree() {
		TreeResult result = service.tree();
		System.out.println(JSON.toJSON(result));
	}

}
