package org.module.commons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.model.commons.db.CmTable;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.commons.db.ICmTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class CmTableTest {

	@Autowired
	private ICmTableService service;

	
	public void insert() {
		CmTable entity = new CmTable();
		entity.setCode(CodeHelper.getUniqueCode("CM"));
		entity.setName("商品表");
		entity.setCreateUser("admin");
		entity.setDbCode("CM");
		service.insertSelective(entity);
	}
	
	public void update(){
		CmTable entity = new CmTable();
		entity.setCode("CM826029142397939712");
		entity.setName("商品表-改");
		entity.setUpdateUser("root");
		entity.setDbCode("DB");
		service.updateByCode(entity);
	}
	
	public void selCode(){
		String code = "CM826029142397939712";
		EntityResult<CmTable> result = service.selectByCode(code);
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del(){
		String code = "CM826029142397939712";
		RootResult result = service.deleteByCode(code);
		System.out.println(JSON.toJSON(result));
	}
}
