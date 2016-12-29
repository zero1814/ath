package org.system.service.impl.role;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseServiceImpl;
import org.system.dto.role.SmRolePermissionDto;
import org.system.mapper.role.SmRolePermissionMapper;
import org.system.model.role.SmRolePermission;
import org.system.service.role.ISmRolePermissionService;

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
