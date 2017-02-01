package org.module.kernel;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.helper.CodeHelper;
import org.module.commons.map.MDataMap;
import org.module.dto.kernel.db.CmDatabaseDto;
import org.module.model.kernel.db.CmDatabase;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.kernel.db.ICmDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class CmDatabaseTest {

	@Autowired
	private ICmDatabaseService service;

	public void insert() {
		CmDatabase entity = new CmDatabase();
		entity.setCode(CodeHelper.getUniqueCode("CM"));
		entity.setName("核心模块");
		entity.setEnName("kernelmodule");
		entity.setUrl(
				"jdbc:mysql://localhost:3306/kernelmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		entity.setCreateUser("admin");
		entity.setUsername("root");
		entity.setPassword("");
		service.insertSelective(entity);
	}

	public void update() {
		CmDatabase entity = new CmDatabase();
		entity.setCode("CM826021920959885312");
		entity.setName("系统模块01");
		entity.setEnName("systemmodule");
		entity.setUrl(
				"jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		entity.setUpdateUser("update_user");
		entity.setUsername("root");
		entity.setPassword("123456");
		service.updateByCode(entity);
	}

	public void selCode() {
		EntityResult<CmDatabase> result = service.selectByCode("CM826021920959885312");
		System.out.println(JSON.toJSON(result));

	}

	public void del() {
		RootResult result = service.deleteByCode("CM826021920959885312");
		System.out.println(JSON.toJSON(result));
	}
	
	
	public void findTableByDb(){
		CmDatabaseDto dto = new CmDatabaseDto();
		dto.setName("kernelmodule");
		System.out.println(JSON.toJSON(service.findTableByDb(dto)));
	}

	@Test
	public void findColumnByTable(){
		CmDatabaseDto dto = new CmDatabaseDto();
		dto.setName("kernelmodule");
		dto.setTableName("cm_table");
		System.out.println(JSON.toJSON(service.findColumnByTable(dto)));		
	}
}
