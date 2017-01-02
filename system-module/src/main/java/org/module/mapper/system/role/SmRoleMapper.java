package org.module.mapper.system.role;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.role.SmRoleDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.role.SmRole;

/**
 * 
 * 类: SmRoleMapper <br>
 * 描述: 系统角色数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:25:59
 */
@ObjectExplain(name = "系统角色数据库访问接口", description = "对于systemmodudel库的sm_role表进行数据库操作")
public interface SmRoleMapper extends BaseMapper<SmRole, SmRoleDto> {
}