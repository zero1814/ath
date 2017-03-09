package org.module.commons.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * 
 * 类: SpringCtxUtil <br>
 * 描述: spring加载配置文件公共类 <br>
 * 作者: zhy<br>
 * 时间: 2016年8月30日 上午11:10:08
 */
public class SpringUtil {

	private static ApplicationContext ctx;

	public static void setApplicationContext(ApplicationContext ctx) {
		SpringUtil.ctx = ctx;
	}

	public static ApplicationContext getContext() {
		return ctx;
	}

	public static <T> T getBean(Class<T> clazz) throws BeansException {
		return (T) ctx.getBean(clazz);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) throws BeansException {
		return (T) ctx.getBean(beanName);
	}

}
