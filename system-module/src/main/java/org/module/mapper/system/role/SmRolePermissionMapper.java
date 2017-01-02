package org.module.mapper.system.role;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.role.SmRolePermissionDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.role.SmRolePermission;

/**
 * 
 * 类: SmRolePermissionMapper <br>
 * 描述: 系统角色权限数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:26:20
 */
@ObjectExplain(name = "系统角色权限数据库访问接口", description = "对于systemmodudel库的sm_role_permission表进行数据库操作")
public interface SmRolePermissionMapper extends BaseMapper<SmRolePermission, SmRolePermissionDto> {
}