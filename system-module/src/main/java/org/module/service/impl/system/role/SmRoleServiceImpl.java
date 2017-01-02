package org.module.service.impl.system.role;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.role.SmRoleDto;
import org.module.mapper.system.role.SmRoleMapper;
import org.module.model.system.role.SmRole;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.role.ISmRoleService;

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
