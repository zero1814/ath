package org.module.system.service.impl.role;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseServiceImpl;
import org.module.system.dto.role.SmRolePermissionDto;
import org.module.system.mapper.role.SmRolePermissionMapper;
import org.module.system.model.role.SmRolePermission;
import org.module.system.service.role.ISmRolePermissionService;

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
