
package org.module.commons.base;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.module.commons.annotation.Inject;
import org.module.commons.util.SpringContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * 
 * 类: BaseClass <br>
 * 描述: 公共类 <br>
 * 作者: zhy<br>
 * 时间: 2016年8月30日 上午11:01:41
 */
public abstract class BaseClass {

	public static BaseLog logger = new BaseLog();

	public BaseClass() {
		inject(this.getClass());
	}

	public void inject(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				Inject inject = field.getAnnotation(Inject.class);
				String className = inject.className();
				try {
					if (StringUtils.isNotBlank(className)) {
						Object obj = this.getBean(className);
						field.setAccessible(true);
						field.set(this, obj);
					} else {
						Object obj = this.getBean(field.getType());
						field.setAccessible(true);
						field.set(this, obj);
					}
				} catch (NoSuchBeanDefinitionException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		Class<?> parentClazz = clazz.getSuperclass();
		if (parentClazz != null)
			inject(parentClazz);
	}

	public <T> T getBean(Class<T> clazz) throws BeansException {
		return (T) SpringContextUtil.getBean(clazz);
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName) throws BeansException {
		return (T) SpringContextUtil.getBean(beanName);
	}

	public BaseLog getLogger() {
		return logger;
	}
}
