package system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.model.system.SmDefine;
import org.module.service.system.ISmCodeService;
import org.module.service.system.ISmDefineService;
import org.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SmDefineTest {

	@Autowired
	private ISmDefineService service;
	@Autowired
	private ISmCodeService codeService;

	@Test
	public void insert() {
		SmDefine entity1 = new SmDefine();
		entity1.setCode(codeService.getCode("SD"));
		entity1.setName("用户相关");
		entity1.setCreateUser("system");
		entity1.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity1);

		SmDefine entity2 = new SmDefine();
		entity2.setCode(codeService.getCode("SD"));
		entity2.setParentCode(entity1.getCode());
		entity2.setName("用户类型");
		entity2.setCreateUser("system");
		entity2.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity2);

		SmDefine entity3 = new SmDefine();
		entity3.setCode(codeService.getCode("SD"));
		entity3.setParentCode(entity2.getCode());
		entity3.setName("普通会员");
		entity3.setCreateUser("system");
		entity3.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity3);

		SmDefine entity4 = new SmDefine();
		entity4.setCode(codeService.getCode("SD"));
		entity4.setParentCode(entity1.getCode());
		entity4.setName("用户状态");
		entity4.setCreateUser("system");
		entity4.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity4);

		SmDefine entity5 = new SmDefine();
		entity5.setCode(codeService.getCode("SD"));
		entity5.setParentCode(entity4.getCode());
		entity5.setName("正常");
		entity5.setCreateUser("system");
		entity5.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity5);

		SmDefine entity6 = new SmDefine();
		entity6.setCode(codeService.getCode("SD"));
		entity6.setParentCode(entity4.getCode());
		entity6.setName("注销");
		entity6.setCreateUser("system");
		entity6.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity6);

		SmDefine entity7 = new SmDefine();
		entity7.setCode(codeService.getCode("SD"));
		entity7.setParentCode(entity4.getCode());
		entity7.setName("冻结");
		entity7.setCreateUser("system");
		entity7.setCreateTime(DateUtil.getSysDateTime());
		service.insertSelective(entity7);
	}
}
