package org.system.model.role;

import org.commons.annotation.obj.AttributeExplain;
import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseModel;

@ObjectExplain(name = "角色权限关系", description = "角色权限维护")
public class SmRolePermission extends BaseModel {

	@AttributeExplain(name = "roleCode", isNull = false, description = "角色编码")
	private String roleCode;

	@AttributeExplain(name = "permissionCode", isNull = false, description = "权限编码")
	private String permissionCode;

}