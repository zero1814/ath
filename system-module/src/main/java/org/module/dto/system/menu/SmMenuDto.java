package org.module.dto.system.menu;

import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.dto.BaseDto;

@Object(name = "菜单参数类", description = "用于查询菜单相关信息的参数")
public class SmMenuDto extends BaseDto {

	@Attribute(name = "name", description = "菜单名称")
	private String name;

	@Attribute(name = "groupCode", description = "菜单组编码")
	private String groupCode;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}