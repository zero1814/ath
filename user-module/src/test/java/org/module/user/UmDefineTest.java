package org.module.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.base.BaseTest;
import org.module.helper.commons.CodeHelper;
import org.module.model.user.UmDefine;
import org.module.result.EntityResult;
import org.module.result.BaseResult;
import org.module.result.TreeResult;
import org.module.service.user.IUmDefineService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml","classpath:spring/spring-redis.xml" })
public class UmDefineTest extends BaseTest {

	@Autowired
	private IUmDefineService service;

	public void insert() {
		UmDefine entity = new UmDefine();
		entity.setCode(CodeHelper.getUniqueCode("UD"));
		entity.setName("用户状态");
		entity.setCreateUser("sys");
		entity.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity);

		UmDefine entity1 = new UmDefine();
		entity1.setCode(CodeHelper.getUniqueCode("UD"));
		entity1.setParentCode(entity.getCode());
		entity1.setName("正常");
		entity1.setCreateUser("sys");
		entity1.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity1);

		UmDefine entity2 = new UmDefine();
		entity2.setCode(CodeHelper.getUniqueCode("UD"));
		entity2.setParentCode(entity.getCode());
		entity2.setName("已注销");
		entity2.setCreateUser("sys");
		entity2.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity2);

		UmDefine entity3 = new UmDefine();
		entity3.setCode(CodeHelper.getUniqueCode("UD"));
		entity3.setName("已删除");
		entity3.setCreateUser("sys");
		entity3.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity3);
	}

	public void edit() {
		UmDefine entity = new UmDefine();
		entity.setCode("UD888277548570505216");
		entity.setName("用户状态-改");
		entity.setUpdateUser("edit");
		entity.setUpdateTime(DateUtil.getSysDateTime());
		service.updateByCode(entity);
	}

	@Test
	public void tree() {
		TreeResult result = service.treeData();
		System.out.println(JSON.toJSON(result));
	}

	public void sel() {
		EntityResult result = service.selectByCode("UD888277548570505216");
		System.out.println(JSON.toJSON(result));
	}

	public void del() {
		BaseResult result = service.deleteByCode("UD888277548570505216");
		System.out.println(JSON.toJSON(result));
	}
}
