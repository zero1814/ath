package org.module.util;

import java.lang.reflect.Field;
import java.util.List;

import org.module.annotation.validation.Insert;
import org.module.annotation.validation.Update;
import org.module.base.result.BaseResult;

public class ValidationUtil {

	public static BaseResult insert(Object obj) {
		BaseResult result = new BaseResult();
		try {
			Class<?> clazz = obj.getClass();
			List<Field> fields = BeanUtil.getFields(clazz);
			for (Field field : fields) {
				if (field.isAnnotationPresent(Insert.class)) {
					field.setAccessible(true);
					// 获取属性值
					Insert insert = field.getAnnotation(Insert.class);
					boolean flag = insert.notNull();
					if (flag) {
						Object fieldVal = field.get(obj);
						if (fieldVal == null) {
							result.setCode(Constant.RESULT_ERROR);
							result.setMessage(insert.alert());
							return result;
						} else {
							if (fieldVal instanceof String) {
								if (StringUtils.isBlank(fieldVal)) {
									result.setCode(Constant.RESULT_ERROR);
									result.setMessage(insert.alert());
									return result;
								}
							}
						}
					}
				} else {
					continue;
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
			List<Field> fields = BeanUtil.getFields(clazz);
			for (Field field : fields) {
				if (field.isAnnotationPresent(Update.class)) {
					Update update = field.getAnnotation(Update.class);
					boolean flag = update.notNull();
					if (flag) {
						field.setAccessible(true);
						// 获取属性值
						Object fieldVal = field.get(obj);
						if (fieldVal instanceof String) {
							if (StringUtils.isBlank(fieldVal)) {
								result.setCode(Constant.RESULT_ERROR);
								result.setMessage(update.alert());
								return result;
							}
						} else {
							result.setCode(Constant.RESULT_ERROR);
							result.setMessage(update.alert());
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
