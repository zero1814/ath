package org.module.commons.db;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;

/**
 * 
 * 类: CreateTable <br>
 * 描述: 创建数据表 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午10:18:54
 */
public class CreateTable {

	public CreateTable() {
		readObj(this.getClass());
	}

	public void readObj(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Table.class)) {
				Table table = field.getAnnotation(Table.class);
				String name = table.name();
				String database = table.database();
				String comment = table.comment();
				if (StringUtils.isNotBlank(name)) {

				}
			}
		}
	}

	public void readProperty(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
			}
		}
	}

	public boolean createColumn(Column column) {
		String name = column.name();
		String jdbcType = column.jdbcType();
		String property = column.property();
		int length = column.length();
		String comment = column.comment();
		String defaultVal = column.defaultVal();
		if (StringUtils.isNotBlank(name)) {

		}
		if (StringUtils.isNotBlank(jdbcType)) {

		}
		if (StringUtils.isNotBlank(property)) {

		}
		if (length > 0) {

		}
		if (StringUtils.isNotBlank(comment)) {

		}
		if (StringUtils.isNotBlank(defaultVal)) {

		}
		return false;
	}
}
