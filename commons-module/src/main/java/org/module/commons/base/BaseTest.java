package org.module.commons.base;

import org.module.commons.util.SpringContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 类: BaseTest <br>
 * 描述: 测试基类 <br>
 * 作者: zhy<br>
 * 时间: 2016年8月3日 下午3:17:00
 */
public class BaseTest implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextUtil.setApplicationContext(context);
	}
}