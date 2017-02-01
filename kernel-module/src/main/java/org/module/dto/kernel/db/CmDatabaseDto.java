package org.module.dto.kernel.db;

import org.module.dto.BaseDto;

/**
 * 
 * 类: CmDatabaseDto <br>
 * 描述: 数据库维护表参数类 <br>
 * 作者: zhy<br>
 * 时间: 2017年1月28日 下午5:31:53
 */
public class CmDatabaseDto extends BaseDto {

	private String name;

	private String tableName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
