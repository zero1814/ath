package org.module.dto.system.menu;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.BaseDto;

/**
 * 
 * 类: SmMenuDto <br>
 * 描述: 系统菜单数据库访问接口参数 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:09:25
 */
@ObjectExplain(name = "系统菜单数据库访问接口参数", description = "对于systemmodudel库的sm_menu表进行数据库操作的参数")
public class SmMenuDto extends BaseDto {

	/**
	 * 分组编码
	 */
	private String groupCode;

	/**
	 * 父级编码
	 */
	private String parentCode;

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
