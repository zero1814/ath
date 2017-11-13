package org.module.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

	@Test
	public void helloWorld() {
		// 获取 SecurityManager 工厂，此处使用 Ini 配置文件初始化 SecurityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 得到 SecurityManager 实例 并绑定给 SecurityUtils
		SecurityManager manage = factory.getInstance();
		SecurityUtils.setSecurityManager(manage);
		// 得到 Subject 及创建用户名/密码身份验证 Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			// 4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			// 5、身份验证失败
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated()); // 断言用户已经登录
		// 退出
		subject.logout();
	}
}
