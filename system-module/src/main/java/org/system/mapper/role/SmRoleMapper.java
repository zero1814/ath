package org.system.mapper.role;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseMapper;
import org.system.dto.role.SmRoleDto;
import org.system.model.role.SmRole;

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