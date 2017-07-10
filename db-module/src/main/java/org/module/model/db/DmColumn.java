package org.module.model.db;

import org.module.model.BaseModel;

/**
 * 
 * 类: DmColumn <br>
 * 描述: 数据表列维护表 <br>
 * 作者: zhy<br>
 * 时间: 2017年4月27日 上午9:36:17
 */
public class DmColumn extends BaseModel {

	private static final long serialVersionUID = -5814252369447736227L;

	private String name;

	private String enName;

	private String tableCode;

	private String typeCode;

	private Integer isDefault;

	private String defaultValue;

	private String comment;

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}