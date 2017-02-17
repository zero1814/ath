package org.module.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassModel {
	/**
	 * 根据属性名获取属性值
	 */
	private Object getFieldValueByName(String fieldName) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = this.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(this, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取属性名数组
	 */
	private String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	public Map<String, Object> getFiledsInfo() {
		Class<?> clazz = this.getClass();
		Map<String, Object> map = getFiledsInfo(clazz);
		if (clazz.getSuperclass() != null) {
			getFiledsInfo(clazz.getSuperclass());
		}
		return map;
	}

	/**
	 * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 */
	private Map<String, Object> getFiledsInfo(Class<?> clazz) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String key = fields[i].getName();
			Object value = getFieldValueByName(fields[i].getName());
			map.put(key, value);
		}
		if (clazz.getSuperclass() != null) {
			Field[] parentFields = this.getClass().getSuperclass().getDeclaredFields();
			for (int i = 0; i < parentFields.length; i++) {
				String key = parentFields[i].getName();
				Object value = getFieldValueByName(parentFields[i].getName());
				if (!map.containsKey(key)) {
					map.put(key, value);
				}
			}
		}
		return map;
	}

	/**
	 * 获取对象的所有属性值，返回一个对象数组
	 */
	public Object[] getFiledValues() {
		String[] fieldNames = this.getFiledName(this);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = getFieldValueByName(fieldNames[i]);
		}
		return value;
	}
}
