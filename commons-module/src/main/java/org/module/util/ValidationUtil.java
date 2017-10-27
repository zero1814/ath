package org.module.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.module.annotation.validation.Insert;
import org.module.annotation.validation.Update;
import org.module.base.result.BaseResult;

public class ValidationUtil {

	public static BaseResult insert(Object obj) {
		BaseResult result = new BaseResult();
		try {
			Class<?> clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Method[] methods = clazz.getDeclaredMethods();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Insert.class)) {
					String fieldGetName = BeanUtil.parGetName(field.getName());
					boolean flag = BeanUtil.checkGetMet(methods, fieldGetName);
					if (flag) {
						field.setAccessible(true);
						// 获取属性值
						Insert insert = field.getAnnotation(Insert.class);
						Object fieldVal = field.get(obj);
						if (fieldVal instanceof String) {
							if (StringUtils.isBlank(fieldVal)) {
								result.setCode(Constant.RESULT_ERROR);
								result.setMessage(insert.alert());
								return result;
							}
						} else {
							result.setCode(Constant.RESULT_ERROR);
							result.setMessage(insert.alert());
							return result;
						}
					} else {
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static BaseResult update(Object obj) {
		BaseResult result = new BaseResult();
		try {
			Class<?> clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Method[] methods = clazz.getDeclaredMethods();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Update.class)) {
					String fieldGetName = BeanUtil.parGetName(field.getName());
					boolean flag = BeanUtil.checkGetMet(methods, fieldGetName);
					if (flag) {
						field.setAccessible(true);
						// 获取属性值
						Update insert = field.getAnnotation(Update.class);
						Object fieldVal = field.get(obj);
						if (fieldVal instanceof String) {
							if (StringUtils.isBlank(fieldVal)) {
								result.setCode(Constant.RESULT_ERROR);
								result.setMessage(insert.alert());
								return result;
							}
						} else {
							result.setCode(Constant.RESULT_ERROR);
							result.setMessage(insert.alert());
							return result;
						}
					} else {
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
