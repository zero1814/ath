package org.module.service.impl.system.role;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseServiceImpl;
import org.module.dto.system.role.SmRolePermissionDto;
import org.module.mapper.system.role.SmRolePermissionMapper;
import org.module.model.system.role.SmRolePermission;
import org.module.service.system.role.ISmRolePermissionService;

/**
 * 
 * 类: SmRolePermissionServiceImpl <br>
 * 描述: 系统角色权限业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:49:32
 */
@ObjectExplain(name = "系统角色权限业务逻辑访问接口", description = "对系统角色权限相关业务逻辑操作接口")
public class SmRolePermissionServiceImpl
		extends BaseServiceImpl<SmRolePermission, SmRolePermissionMapper, SmRolePermissionDto>
		implements ISmRolePermissionService {

}
