package org.module.model.system.role;

import org.module.commons.annotation.obj.AttributeExplain;
import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseModel;

@ObjectExplain(name = "系统角色", description = "系统角色维护")
public class SmRole extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "角色编码")
	private String code;

	@AttributeExplain(name = "name", isNull = false, description = "角色名称")
	private String name;

	@AttributeExplain(name = "flagAble", defaultVal = "0", description = "是否可用 0 可用 1 不可用")
	private Integer flagAble;

}