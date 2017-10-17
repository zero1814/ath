package org.module.dto.system.menu;

import org.module.base.dto.BaseDto;

/**
 * 
 * 类: SmMenuDto <br>
 * 描述: 菜单参数类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:54:02
 */
public class SmMenuDto extends BaseDto {

	private String parentCode;

	private String groupCode;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

}
