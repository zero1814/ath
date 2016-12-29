package org.system.service.impl.role;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseServiceImpl;
import org.system.dto.role.SmRoleDto;
import org.system.mapper.role.SmRoleMapper;
import org.system.model.role.SmRole;
import org.system.service.role.ISmRoleService;

/**
 * 
 * 类: SmRoleServiceImpl <br>
 * 描述: TODO <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:49:58
 */
@ObjectExplain(name = "系统角色业务逻辑访问接口", description = "对系统角色相关业务逻辑操作接口")
public class SmRoleServiceImpl extends BaseServiceImpl<SmRole, SmRoleMapper, SmRoleDto> implements ISmRoleService {

}
