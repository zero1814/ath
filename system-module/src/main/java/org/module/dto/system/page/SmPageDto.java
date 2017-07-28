package org.module.dto.system.page;

import org.module.dto.BaseDto;

/**
 * 
 * 类: SmPageDto <br>
 * 描述: 页面参数类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:54:22
 */
public class SmPageDto extends BaseDto {

	private String groupCode;

	private String parentCode;

	private Integer flagAble;

	public Integer getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(Integer flagAble) {
		this.flagAble = flagAble;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
